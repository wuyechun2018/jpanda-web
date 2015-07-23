package org.jpanda.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.model.system.SysCity;
import org.jpanda.service.system.SysCityService;
import org.jpanda.util.JsonMsg;
import org.jpanda.util.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*******************************************************************************
 *  功能说明: 城市维护 控制层
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysCity")
public class SysCityController {
	
	@Autowired
	private SysCityService sysCityService;
	
	/***
	 * 
	 * 功能 :保存系统定义
	
	 * 开发：ycwu 2014-10-13
	
	 * @param dmsDictionary
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(SysCity sysCity,HttpServletRequest request){
		sysCityService.save(sysCity);
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
	public Object delete(String ids) {
		sysCityService.deleteCity(ids);
		return new JsonMsg();
	}
	
	/**
	 * 
	 * 功能 :分页数据查询
	
	 * 开发：ycwu 2014-10-11
	
	 * @param searchKey
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageObject<?> list(String searchKey,String provinceCode,int start,int limit){
		
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("searchKey", searchKey);
		params.put("provinceCode", provinceCode);
		return sysCityService.getCityListPage(params,start,limit);
		
		//return sysCityService.getCityList(searchKey,provinceCode,Integer.parseInt(start),Integer.parseInt(limit));
	}
	
	
	/***
	 * 
	 * 功能 :根据省份编码获取市数据
	
	 * 开发：ycwu 2014-10-28
	
	 * @param provinceCode
	 * @return
	 */
	@RequestMapping(value = "/getCityList")
	@ResponseBody
	public Object getCityList(String provinceCode){
		return sysCityService.getCityListByProvinceCode(provinceCode);
	}
	
	
	/***
	 * 
	 * 功能 :获取城市信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @param cityCode
	 * @return
	 */
	@RequestMapping(value = "/getCity")
	@ResponseBody
	public Object getCity(String cityCode){
		Object obj=sysCityService.getCityInfo(cityCode);
		if(obj!=null){
			return obj;
		}else{
			return new JsonMsg();
		}
		
	}


}
