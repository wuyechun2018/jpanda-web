package org.jpanda.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.service.system.SysLoginUserService;
import org.jpanda.util.JqGrid;
import org.jpanda.util.PageObject;
import org.jpanda.util.Pager;
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
	public Object list(int rows,int page,HttpServletRequest request){
		
		//每页显示行数
		//String rows=request.getParameter("rows");
		//当前页数
		//String page=request.getParameter("page");
		
		PageObject pageObj=loginUserService.getUserList(new Pager(page,rows));
		JqGrid jqGrid=new JqGrid();
		jqGrid.setRows(pageObj.getList());
	    jqGrid.setRecords(pageObj.getTotalCount());
	    jqGrid.setPageSize(rows);
		return jqGrid;
	}
	

}
