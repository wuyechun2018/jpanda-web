package org.jpanda.service.system;

import java.util.List;

import org.jpanda.dao.system.imp.SysLoginUserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysLoginUserService {
	
	 @Autowired
	 private SysLoginUserDaoImp sysLoginUserDaoImp;
	 
	 
	 
	 public List getUserList(){
		 return sysLoginUserDaoImp.list();
	 }
	 
}
