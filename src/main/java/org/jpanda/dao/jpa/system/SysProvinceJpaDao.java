package org.jpanda.dao.jpa.system;
import java.util.List;

import org.jpanda.model.system.SysProvince;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
/*******************************************************************************
 *  功能说明: 省份维护 数据访问层-Spring Data JPA
  
 *  2014-10-23 下午1:08:13 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-10-23 下午1:08:13 ycwu 修改文件
 * 
 ******************************************************************************/
public interface SysProvinceJpaDao extends PagingAndSortingRepository<SysProvince, Long>,
JpaSpecificationExecutor<SysProvince>{

	/**
	 * 
	 * 功能 :根据省份编码获取省份信息
	
	 * 开发：ycwu 2014-10-27
	
	 * @param provinceCode
	 * @return
	 */
	SysProvince findByProvinceCode(String provinceCode);


	/***
	 * 
	 * 功能 :功能 :查询所有省份（排序）
	
	 * 开发：ycwu 2014-10-28
	
	 * @return
	 */
	@Query(value="select * from sys_province t order by t.orderby" ,nativeQuery=true) 
	List<SysProvince> findAllProvinceList();

}
