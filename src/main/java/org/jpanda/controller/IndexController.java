package org.jpanda.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.jpanda.model.SysLoginUser;
import org.jpanda.service.system.SysLoginUserService;
import org.jpanda.util.Constant;
import org.jpanda.util.MD5StrGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	/**
	 * 
	 * 功能 :跳转到首页
	
	 * 开发：wuyechun 2015-5-29
	
	 * @return
	 */
	@RequestMapping({"/","/index","/welcome"})
	public String index(){
		return "index";
	}
	
	
	
	/**
	 * 
	 * 功能 :系统用户登录
	
	 * 开发：wuyechun 2015-6-1
	
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session){
		
		List<SysLoginUser> userList=sysLoginUserService.findByLoginAccount(username);
		
		if(userList!=null&&!userList.isEmpty()){
			SysLoginUser sysLoginUser=userList.get(0);
			if(sysLoginUser!=null){
				password=MD5StrGen.GetMD5Str32(MD5StrGen.GetMD5Str32(password));
				if(password.equals(sysLoginUser.getLoginPwd())&&!"D".equals(sysLoginUser.getUserState())){
					session.setAttribute(Constant.CURRENT_USER, sysLoginUser);
					return "/system/main";
				}
				
			}else{
				
			}
		}
		return "index";
	}
	
	
	/**
	 * 
	 * 功能 :系统用户登录
	
	 * 开发：wuyechun 2015-6-1
	
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	
	
	/**
	 * 
	 * 功能 :系统跳转页面公用方法
	
	 * 开发：wuyechun 2013-9-3
	
	 * @param module
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "views/{module}/{page}")
	public String getDefinedPage(@PathVariable("module") String module,@PathVariable("page") String page) {
		return module+"/"+page;
	}

}
