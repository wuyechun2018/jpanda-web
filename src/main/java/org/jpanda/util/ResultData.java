package org.jpanda.util;

import java.util.List;

public class ResultData<T> {
	private Long totalCount;
	private List<T> list;
	 
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
