package org.jpanda.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.service.app.AppDispDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appDispData")
public class AppDispDataController {
	@Autowired
	private AppDispDataService appDispDataService;
	
	/**
	 * 
	 * 功能 :获取用于展示的XML
	
	 * 开发：ycwu 2014-10-9
	
	 * @return
	 */
	@RequestMapping(value = "/getShowXML")
	@ResponseBody
	public String getShowXML(HttpServletRequest request){
		return appDispDataService.getRealXMLByFreeMarker(request);
	}

}
