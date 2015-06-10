package org.jpanda.service.system;

import java.util.List;

import org.jpanda.dao.jdbc.system.imp.SysLoginUserDaoImp;
import org.jpanda.dao.jpa.system.SysLoginUserJpaDao;
import org.jpanda.model.SysLoginUser;
import org.jpanda.util.Pager;
import org.jpanda.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*******************************************************************************
 * 功能说明:登录用户维护 Service层
 * 
 * 2015-06-05 下午3:13:00 wuyechun 创建文件
 * 
 * 修改说明: 创建文件
 * 
 * 2015-06-05 下午3:13:00 wuyechun 修改文件
 * 
 ******************************************************************************/
@Component
public class SysLoginUserService {
	
	 @Autowired
	 private SysLoginUserDaoImp sysLoginUserDaoImp;
	 @Autowired
	 private SysLoginUserJpaDao sysLoginUserJpaDao;
	 
	 
	 /**
	  * 
	  * 功能 :获取用户列表-分页
	 
	  * 开发：wuyechun 2015-6-5
	 
	  * @param page
	  * @return
	  */
	 public ResultData getUserList(Pager page){
		 return sysLoginUserDaoImp.list(page);
	 }
	 
	 
	 /**
	  * 
	  * 功能 :根据登录账号查询
	 
	  * 开发：wuyechun 2015-6-5
	 
	  * @param loginAccount
	  * @return
	  */
	 public List<SysLoginUser> findByLoginAccount(String loginAccount){
		 
		 //此处的两种用法都是可以的
		 //1、采用的是JDBC的方式
		 //2、采用的Spring Data JPA 的方式
		 
		 //return sysLoginUserDaoImp.findByLoginAccount(loginAccount);
		 return sysLoginUserJpaDao.findByLoginAccount(loginAccount);
	 }
	 
}
