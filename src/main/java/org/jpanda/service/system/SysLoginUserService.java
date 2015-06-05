package org.jpanda.service.system;

import org.jpanda.dao.system.imp.SysLoginUserDaoImp;
import org.jpanda.util.ResultData;
import org.jpanda.util.Pager;
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
	 
}
