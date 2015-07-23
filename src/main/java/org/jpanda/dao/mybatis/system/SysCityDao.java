package org.jpanda.dao.mybatis.system;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jpanda.common.mybatis.MyBatisRepository;
import org.jpanda.dto.system.SysCityProvinceDto;

@MyBatisRepository
public interface SysCityDao {

	List<SysCityProvinceDto> findPager(Map<String, Object> listParams);

	int findCount(Map<String, Object> listParams);

	Object getCityInfo(@Param("cityCode")String cityCode);

	List getListPage(Map<String, Object> params);

}
