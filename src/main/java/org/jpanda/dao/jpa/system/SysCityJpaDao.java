package org.jpanda.dao.jpa.system;

import java.util.List;

import org.jpanda.model.system.SysCity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
/*******************************************************************************
 *  功能说明: 城市维护 数据访问层-Spring Data JPA
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
public interface SysCityJpaDao extends PagingAndSortingRepository<SysCity, Long>,
JpaSpecificationExecutor<SysCity>{

	@Query(value="select * from sys_city t where t.province_code=?1 order by t.orderby" ,nativeQuery=true) 
	List<SysCity> findByProvinceCode(String provinceCode);

	/**
	 * 
	 * 功能 :根据城市编码获取城市信息
	
	 * 开发：ycwu 2014-10-28
	
	 * @param cityCode
	 * @return
	 */
	SysCity findByCityCode(String cityCode);

}
