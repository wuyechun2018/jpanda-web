
package org.jpanda.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.service.system.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*******************************************************************************
 *  功能说明: 菜单维护 控制层
  
 *  2014-1-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-1-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	/**
	 * 
	 * 功能 :
	
	 * 开发：ycwu 2014-7-28
	
	 * @param node
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getChildList")
	@ResponseBody
	public Object getChildList(String node,HttpServletRequest request){
		return sysMenuService.getChildList(node,request);
	}

}


