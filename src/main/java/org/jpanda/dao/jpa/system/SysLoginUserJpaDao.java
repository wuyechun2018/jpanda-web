package org.jpanda.dao.jpa.system;

import java.util.List;

import org.jpanda.model.system.SysLoginUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysLoginUserJpaDao  extends PagingAndSortingRepository<SysLoginUser, Long>{

	List<SysLoginUser> findByLoginAccount(String loginAccount);

	
}
