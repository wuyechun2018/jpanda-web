package org.jpanda.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.service.system.SysLoginUserService;
import org.jpanda.util.JqGrid;
import org.jpanda.util.ResultData;
import org.jpanda.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*******************************************************************************
 * 功能说明:登录用户维护 Controller 层
 * 
 * 2015-06-05 下午3:13:00 wuyechun 创建文件
 * 
 * 修改说明: 创建文件
 * 
 * 2015-06-05 下午3:13:00 wuyechun 修改文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysLoginUser")
public class SysLoginUserController {
	
	@Autowired
	private SysLoginUserService loginUserService;
	
	/***
	 * 
	 * 功能 :用户列表
	
	 * 开发：wuyechun 2015-6-5
	
	 * @param rows  每页显示行数 (Jqgrid固定参数）
	 * @param page  当前页数(Jqgrid固定参数）
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(int rows,int page,HttpServletRequest request){
		
		//传入参数封装成Pager对象,两个重要参数 “当前页”和“每页显示数”
		ResultData pageObj=loginUserService.getUserList(new Pager(page,rows));
		
		//对于使用JqGrid，要封装成JqGrid对象返回前端
		JqGrid jqGrid=new JqGrid();
		jqGrid.setRows(pageObj.getList());
	    jqGrid.setRecords(pageObj.getTotalCount());
	    jqGrid.setPageSize(rows);
		return jqGrid;
	}
	

}
