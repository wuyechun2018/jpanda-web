package org.jpanda.util;

public class OracleSqlHelper {
	
	/**
	 * 
	 * 功能 :获取数据
	
	 * 开发:wuyechun 2015-6-4
	
	 * @param sql
	 * @param start 记录开始
	 * @param limit 每页显示数
	 * @return
	 */
	public static String getPagerSql(String sql,Pager page){
		
		StringBuffer sqlBuff=new StringBuffer();
		
		sqlBuff.append("SELECT * FROM (\n" +
						"SELECT s.*,ROWNUM RN FROM(\n");
		sqlBuff.append(sql);
		sqlBuff.append(")s)w WHERE RN>"+page.getStart()+" AND RN<="+page.getEnd()+"");
		
		return sqlBuff.toString();
	}
	
	
	/**
	 * 
	 * 功能 :获取记录总数
	
	 * 开发：wuyechun 2015-6-4
	
	 * @param sql
	 * @return
	 */
	public static String getCountSql(String sql){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("SELECT COUNT(1) FROM(\n");
		sqlBuff.append(sql);
		sqlBuff.append(")");
		return sqlBuff.toString();
	}
	
	

}
