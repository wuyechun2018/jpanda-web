package org.jpanda.util;

import java.util.List;

public class JqGrid {

	//记录总数
	private Long records;
	//记录数据
	private List rows;
	//总页数
	private int total;
	//每页显示数
	private int pageSize;
	

	public JqGrid() {
		super();
	}

	public JqGrid(Long records, List rows, int total, int pageSize) {
		super();
		this.records = records;
		this.rows = rows;
		this.total = total;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getRecords() {
		return records;
	}
	
	public void setRecords(Long records) {
		this.records = records;
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return records/pageSize+1;
	}
	public void setTotal(int total) {
		this.total = total;
	}
  
	
	
	

	

}
