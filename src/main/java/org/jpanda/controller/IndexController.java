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

}
