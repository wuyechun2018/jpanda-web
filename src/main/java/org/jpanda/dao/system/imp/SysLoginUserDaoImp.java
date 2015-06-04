package org.jpanda.dao.system.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jpanda.dao.system.JdbcSupportDao;
import org.jpanda.dao.system.LoginUserDao;
import org.jpanda.model.SysLoginUser;
import org.jpanda.util.OracleSqlHelper;
import org.jpanda.util.PageObject;
import org.jpanda.util.Pager;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SysLoginUserDaoImp  extends JdbcSupportDao  implements LoginUserDao {
	
	 public PageObject list(Pager page){
		 
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
			            	loginUser.setUserCode(rs.getString(3));
			            	loginUser.setSex(rs.getString(4));
			            	loginUser.setLoginAccount(rs.getString(5));
			            	loginUser.setLoginPwd(rs.getString(6));
			            	loginUser.setUserEmail(rs.getString(7));
			            	loginUser.setUserState(rs.getString(8));
			            	loginUser.setUserType(rs.getString(9));
			            	loginUser.setUserTheme(rs.getString(10));
			            	loginUser.setMemo(rs.getString(11));
			                return loginUser;
			            }
			        });
		 PageObject pageObj=new PageObject();
		 pageObj.setList(userList);
		 pageObj.setTotalCount(getCount(OracleSqlHelper.getCountSql(sql)));
		 
		 return pageObj;
	 }
	 
	 
	 
	 class LoginUserRowMapper implements RowMapper<SysLoginUser>{
		@Override
		public SysLoginUser mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			SysLoginUser loginUser = new SysLoginUser();
            return loginUser;
		}
	 }
	 
	 

}
