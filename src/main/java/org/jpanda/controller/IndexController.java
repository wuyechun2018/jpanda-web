package org.jpanda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
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
	public String login(String username,String password){
		
		if(username!=null&&password!=null){
			if("admin".equals(username)&&"123".equals(password)){
				return "/system/main";
			}
			
		}else{
			
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
