package org.jpanda.controller.system;

import java.util.List;

import org.jpanda.service.system.SysLoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sysLoginUser")
public class SysLoginUserController {
	
	@Autowired
	private SysLoginUserService loginUserService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List list(){
		return loginUserService.getUserList();
	}
	

}
