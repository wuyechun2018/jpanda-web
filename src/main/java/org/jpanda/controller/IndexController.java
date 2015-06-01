package org.jpanda.controller;

import org.springframework.stereotype.Controller;
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
				return "main";
			}
			
		}else{
			
		}
		return "index";
	}
	

}
