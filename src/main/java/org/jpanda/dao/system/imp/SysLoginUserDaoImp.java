package org.jpanda.dao.system.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jpanda.dao.system.JdbcSupportDao;
import org.jpanda.dao.system.SysLoginUserDao;
import org.jpanda.model.SysLoginUser;
import org.jpanda.util.OracleSqlHelper;
import org.jpanda.util.ResultData;
import org.jpanda.util.Pager;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SysLoginUserDaoImp  extends JdbcSupportDao  implements SysLoginUserDao {
	
	/***
	 * 
	 * 功能 :用户列表
	
	 * 开发：wuyechun 2015-6-5
	
	 * @param page
	 * @return
	 */
	@Override
	 public ResultData list(Pager page){
		 String sql="SELECT t.user_id,\n" +
						 "       t.user_name,\n" + 
						 "       t.user_alias,\n" + 
						 "       t.user_code,\n" + 
						 "       t.sex,\n" + 
						 "       t.login_account,\n" + 
						 "       t.login_pwd,\n" + 
						 "       t.user_email,\n" + 
						 "       t.user_state,\n" + 
						 "       t.user_type,\n" + 
						 "       t.user_theme,\n" + 
						 "       t.memo\n" + 
						 "  FROM SYS_LOGIN_USER t";
		 
		 
		 List<SysLoginUser> userList = getJdbcTemplate().query(
			        OracleSqlHelper.getPagerSql(sql,page),
			        new RowMapper<SysLoginUser>() {
			            public SysLoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	SysLoginUser loginUser = new SysLoginUser();
			            	loginUser.setUserId(rs.getLong(1));
			            	loginUser.setUserName(rs.getString(2));
			            	loginUser.setUserAlias(rs.getString(3));
			            	loginUser.setUserCode(rs.getString(4));
			            	loginUser.setSex(rs.getString(5));
			            	loginUser.setLoginAccount(rs.getString(6));
			            	loginUser.setLoginPwd(rs.getString(7));
			            	loginUser.setUserEmail(rs.getString(8));
			            	loginUser.setUserState(rs.getString(9));
			            	loginUser.setUserType(rs.getString(10));
			            	loginUser.setUserTheme(rs.getString(11));
			            	loginUser.setMemo(rs.getString(12));
			                return loginUser;
			            }
			        });
		 ResultData resultData=new ResultData();
		 resultData.setList(userList);
		 resultData.setTotalCount(getCount(OracleSqlHelper.getCountSql(sql)));
		 
		 return resultData;
	 }
	 
	/**
	 * 
	 * 功能 :根据登录账号查询
	
	 * 开发：wueychun 2015-6-5
	
	 * @return
	 */
	public List<SysLoginUser> findByLoginAccount(String loginAccount){
		
		String sql="SELECT t.user_id,\n" +
				 "       t.user_name,\n" + 
				 "       t.user_alias,\n" + 
				 "       t.user_code,\n" + 
				 "       t.sex,\n" + 
				 "       t.login_account,\n" + 
				 "       t.login_pwd,\n" + 
				 "       t.user_email,\n" + 
				 "       t.user_state,\n" + 
				 "       t.user_type,\n" + 
				 "       t.user_theme,\n" + 
				 "       t.memo\n" + 
				 "  FROM SYS_LOGIN_USER t WHERE t.login_account=?";
		
		
		List<SysLoginUser> userList =getJdbcTemplate().query(
		        sql,
		        new Object[]{loginAccount},
		        new LoginUserRowMapper());
		return userList;
	}
	
	
	/**
	 * 
	 * 功能 :根据主键查询
	
	 * 开发：wueychun 2015-6-5
	
	 * @return
	 */
	public SysLoginUser findByUserId(String userId){
		
		String sql="SELECT t.user_id,\n" +
				 "       t.user_name,\n" + 
				 "       t.user_alias,\n" + 
				 "       t.user_code,\n" + 
				 "       t.sex,\n" + 
				 "       t.login_account,\n" + 
				 "       t.login_pwd,\n" + 
				 "       t.user_email,\n" + 
				 "       t.user_state,\n" + 
				 "       t.user_type,\n" + 
				 "       t.user_theme,\n" + 
				 "       t.memo\n" + 
				 "  FROM SYS_LOGIN_USER t WHERE t.user_id=?";
		
		
		SysLoginUser loginUser = getJdbcTemplate().queryForObject(
		        sql,
		        new Object[]{userId},
		        new LoginUserRowMapper());
		return loginUser;
	}
	
	 
	 
	 class LoginUserRowMapper implements RowMapper<SysLoginUser>{
		@Override
		public SysLoginUser mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			SysLoginUser loginUser = new SysLoginUser();
        	loginUser.setUserId(rs.getLong(1));
        	loginUser.setUserName(rs.getString(2));
        	loginUser.setUserAlias(rs.getString(3));
        	loginUser.setUserCode(rs.getString(4));
        	loginUser.setSex(rs.getString(5));
        	loginUser.setLoginAccount(rs.getString(6));
        	loginUser.setLoginPwd(rs.getString(7));
        	loginUser.setUserEmail(rs.getString(8));
        	loginUser.setUserState(rs.getString(9));
        	loginUser.setUserType(rs.getString(10));
        	loginUser.setUserTheme(rs.getString(11));
        	loginUser.setMemo(rs.getString(12));
            return loginUser;
		}
	 }
	 
	 

}
