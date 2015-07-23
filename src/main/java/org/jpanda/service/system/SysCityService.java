package org.jpanda.service.system;

import java.util.List;
import java.util.Map;

import org.jpanda.common.mybatis.Pager;
import org.jpanda.dao.jpa.system.SysCityJpaDao;
import org.jpanda.dao.mybatis.system.SysCityDao;
import org.jpanda.model.system.SysCity;
import org.jpanda.util.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*******************************************************************************
 *  功能说明: 城市维护 服务层
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
@Component
public class SysCityService {
	@Autowired
	private SysCityJpaDao sysCityJpaDao;

	@Autowired
	private SysCityDao sysCityDao;
	
	/**
	 * 
	 * 功能 :保存
	
	 * 开发：ycwu 2014-10-27
	
	 * @param sysCity
	 */
	public void save(SysCity sysCity) {
		sysCityJpaDao.save(sysCity);
	}

	/**
	 * 
	 * 功能 :删除
	
	 * 开发：ycwu 2014-10-27
	
	 * @param ids
	 */
	public void deleteCity(String ids) {
		String []idArray=ids.split(",");
		for(int i=0;i<idArray.length;i++){
			sysCityJpaDao.delete(Long.valueOf(idArray[i]));
		}
	}

	/***
	 * 
	 * 功能 :列表
	
	 * 开发：ycwu 2014-10-27
	
	 * @param searchKey
	 * @param provinceId
	 * @param start
	 * @param limit
	 * @return
	 */
	public PageObject<?> getCityList(String searchKey, String provinceCode,int start, int limit) {
		
		/**
		Map<String, Object> listParams = new HashMap<String, Object>();
		listParams.put(Constant.PAGE_START, start);
		listParams.put(Constant.PAGE_END, start+limit);
		//keyword为查询框输入的关键字
		listParams.put("keyword", searchKey);
		listParams.put("provinceCode", provinceCode);
		//查询数据
		List<SysCityProvinceDto> list = sysCityDao.findPager(listParams);
		//查询数量
		int count=sysCityDao.findCount(listParams);
		
		PageObject<SysCityProvinceDto> pg = new PageObject<SysCityProvinceDto>();
		pg.setTotalCount(Long.valueOf(count));
		pg.setList(list);
		return pg;**/
		return null;
	}

	/**
	 * 
	 * 功能 :获取市信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @param provinceCode
	 * @return
	 */
	public List<SysCity> getCityListByProvinceCode(String provinceCode) {
		return sysCityJpaDao.findByProvinceCode(provinceCode);
	}

	/***
	 * 
	 * 功能 :获取城市信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @param cityCode
	 * @return
	 */
	public SysCity getCity(String cityCode) {
		return sysCityJpaDao.findByCityCode(cityCode);
	}
	
	/***
	 * 
	 * 功能 :获取城市信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @param cityCode
	 * @return
	 */
	public Object getCityInfo(String cityCode) {
		//return sysCityDao.getCityInfo(cityCode);
		return null;
	}

	/***
	 * 
	 * 功能 :分页数据查询
	
	 * 开发：ycwu 2014-12-9
	
	 * @param params
	 * @param start
	 * @param limit
	 * @return
	 */
	public PageObject<?> getCityListPage(Map<String, Object> params,int start, int limit) {
		/*****/
		Pager page = Pager.getInitPager(start, limit);
		params.put("page", page);
		List list = sysCityDao.getListPage(params);
		PageObject<?> pg = new PageObject();
		pg.setTotalCount(Long.valueOf(page.getTotal()));
		pg.setList(list);
		return pg;
		//return null;
	}

}
