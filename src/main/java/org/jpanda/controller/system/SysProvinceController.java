package org.jpanda.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.model.system.SysProvince;
import org.jpanda.service.system.SysProvinceService;
import org.jpanda.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*******************************************************************************
 *  功能说明: 省份维护 控制层
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysProvince")
public class SysProvinceController {
	
	@Autowired
	private SysProvinceService sysProvinceService;
	
	/**
	 * 
	 * 功能 :获取所有的省份信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @return
	 */
	@RequestMapping(value="/getAllProvinceList")
	@ResponseBody
	public Object getAllProvinceList(){
		return sysProvinceService.getAllProvinceList();
	}
	
	
	/**
	 * 
	 * 功能 :获取省份
	
	 * 开发：ycwu 2014-7-28
	
	 * @param node
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getPorvinceList")
	@ResponseBody
	public Object getPorvinceList(String node,HttpServletRequest request){
		return sysProvinceService.getPorvinceList(node,request);
	}
	
	
	/***
	 * 
	 * 功能 :根据省份编码获取省份信息
	
	 * 开发：ycwu 2014-10-27
	
	 * @param provinceCode
	 * @return
	 */
	@RequestMapping(value="/getProvince")
	@ResponseBody
	public Object getProvince(String id){
		return sysProvinceService.findById(Long.valueOf(id));
	}
	
	
	/***
	 * 
	 * 功能 :保存数据
	
	 * 开发：ycwu 2014-10-13
	
	 * @param dmsDictionary
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(SysProvince sysProvince){
		sysProvinceService.save(sysProvince);
		return new JsonMsg();
	}
	
	/**
	 * 
	 * 功能 :删除操作
	
	 * 开发：ycwu 2014-10-13
	
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(String id) {
		sysProvinceService.delete(Long.valueOf(id));
		return new JsonMsg();
	}

}
