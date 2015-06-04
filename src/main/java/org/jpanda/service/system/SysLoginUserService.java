package org.jpanda.service.system;

import org.jpanda.dao.system.imp.SysLoginUserDaoImp;
import org.jpanda.util.PageObject;
import org.jpanda.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysLoginUserService {
	
	 @Autowired
	 private SysLoginUserDaoImp sysLoginUserDaoImp;
	 
	 
	 
	 public PageObject getUserList(Pager page){
		 return sysLoginUserDaoImp.list(page);
	 }
	 
}
