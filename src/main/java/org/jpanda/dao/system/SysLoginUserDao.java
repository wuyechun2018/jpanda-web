package org.jpanda.dao.system;

import org.jpanda.util.Pager;
import org.jpanda.util.ResultData;

public interface SysLoginUserDao {

	/**
	 * 
	 * 功能 :列表功能
	
	 * 开发：wuyechun 2015-6-5
	
	 * @param page
	 * @return
	 */
	ResultData list(Pager page);
	

}
