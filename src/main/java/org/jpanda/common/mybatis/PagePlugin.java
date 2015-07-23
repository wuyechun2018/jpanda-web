package org.jpanda.common.mybatis;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagePlugin implements Interceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(PagePlugin.class);

	private String dialect = ""; // 数据库方言
	private String pageSqlId = ""; // mapper.xml中需要拦截的ID(正则匹配)
	private String DIALECT_STR = "dialect";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk
					.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper
					.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement)ReflectHelper
					.getValueByFieldName(delegate, "mappedStatement");

			// 拦截需要分页的SQL
			if (mappedStatement.getId().matches(pageSqlId)) { 
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();
				// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				if (parameterObject == null) {
					throw new NullPointerException("parameterObject尚未实例化！");
				} else {
					Connection connection = (Connection) ivk.getArgs()[0];
					String sql = boundSql.getSql();
					String countSql = "select count(0) as tmp_count from ("
							+ sql + ") t"; // 记录统计

					PreparedStatement countStmt = null;
					ResultSet rs = null;
					int count = 0;
					try {
						countStmt = connection.prepareStatement(countSql);
						BoundSql countBS = new BoundSql(
								mappedStatement.getConfiguration(), countSql,
								boundSql.getParameterMappings(),
								parameterObject);
						setParameters(countStmt, mappedStatement, countBS,
								parameterObject);
						rs = countStmt.executeQuery();
						if (rs.next()) {
							count = rs.getInt(1);
						}
						rs.close();
						countStmt.close();
					} catch (SQLException e) {
						logger.error("执行分页时发生了数据库异常！", e);
						
						try {
							if (rs != null) {
								rs.close();
							}
						} catch (Exception e1) {
						}
						
						try {
							if (countStmt != null) {
								countStmt.close();
							}
						} catch (Exception e1) {
						}
												
						throw e;
					}
					Pager page = null;
					if (parameterObject instanceof Pager) { // 参数就是Page实体
						page = (Pager) parameterObject;
						page.setTotal(count);
					} else if ((parameterObject instanceof Map)
							&& !(parameterObject instanceof List)) {
						// 参数为map,Page为map中的一个对象
						Map<Object, Object> map = (Map<Object, Object>) parameterObject;
						if (null != map.get("list")) {
							List<Object> list = (List<Object>) map.get("list");
							Object obj = list.get(0);
							Field pageField = ReflectHelper
									.getFieldByFieldName(obj, "page");
							if (pageField != null) {
								page = (Pager) ReflectHelper
										.getValueByFieldName(obj, "page");
								if (page == null) {
									page = new Pager();
								}
								page.setTotal(count);
								// 通过反射，对实体对象设置分页对象
								ReflectHelper.setValueByFileNameSup(obj, "page",page); 
							} else {
								throw new NoSuchFieldException(obj.getClass()
										.getName() + "不存在 page 属性！");
							}
							page.setTotal(count);
							list.remove(0);
							list.add(0, obj);
						} else {
							page = (Pager) map.get("page");
							page.setTotal(count);
							map.remove("page");
							map.put("page", page);
						}
					} else { 
						// 参数为某个实体，该实体拥有Page属性
						Field pageField = ReflectHelper.getFieldByFieldName(parameterObject, "page");
						if (pageField != null) {
							page = (Pager)ReflectHelper
									.getValueByFieldName(parameterObject,
											"page");
							if (page == null) {
								page = new Pager();
							}
							page.setTotal(count);
							 // 通过反射，对实体对象设置分页对象
							ReflectHelper.setValueByFileNameSup(parameterObject,"page", page);
						} else {
							throw new NoSuchFieldException(parameterObject
									.getClass().getName() + "不存在 page 属性！");
						}
					}
					String pageSql = generatePageSql(sql, page);
					// 将分页sql语句反射回BoundSql.
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); 
				}
			}
		}
		return ivk.proceed();
	}

	/**
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
	 * DefaultParameterHandler
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws java.sql.SQLException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	private void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException, SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		ErrorContext.instance().activity("setting parameters")
				.object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration
					.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null
					: configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry
							.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName
							.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value)
									.getValue(
											propertyName.substring(prop
													.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject
								.getValue(propertyName);
					}
					@SuppressWarnings("rawtypes")
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException(
								"There was no TypeHandler found for parameter "
										+ propertyName + " of statement "
										+ mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value,
							parameterMapping.getJdbcType());
				}
			}
		}
	}

	/**
	 * 根据数据库方言，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String generatePageSql(String sql, Pager page) {
		if (page != null && notEmpty(dialect)) {
			StringBuffer pageSql = new StringBuffer();
			//MySQL
			if ("mysql".equals(dialect)) {
				pageSql.append(sql);
				pageSql.append(" limit " + page.getCurrentResult() + ","+ page.getSize());
			} else if ("oracle".equals(dialect)) {
			//Oracle	
				pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
				pageSql.append(sql);
				pageSql.append(")tmp_tb where ROWNUM<=");
				pageSql.append(page.getCurrentResult() + page.getSize());
				pageSql.append(") where row_id>");
				pageSql.append(page.getCurrentResult());
			}
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	public void setProperties(Properties p) {
		dialect = p.getProperty(DIALECT_STR);
		if (isEmpty(dialect)) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				logger.error("Mybatis配置文件中未找到dialect字段！");
			}
		}
		pageSqlId = p.getProperty("pageSqlId");
		if (isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				logger.error("Mybatis配置文件中未找到pageSqlId字段！");
			}
		}
	}

	public static boolean notEmpty(String s) {
		return s != null && !"".equals(s) && !"null".equals(s);
	}

	public static boolean isEmpty(String s) {
		return s == null || "".equals(s) || "null".equals(s);
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}
}
