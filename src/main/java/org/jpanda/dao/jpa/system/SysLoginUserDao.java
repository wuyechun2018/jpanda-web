package org.jpanda.dao.jpa.system;

import org.jpanda.model.SysLoginUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysLoginUserDao  extends PagingAndSortingRepository<SysLoginUser, Long>{

}
