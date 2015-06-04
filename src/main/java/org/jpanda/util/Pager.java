package org.jpanda.util;

public class Pager {
	
	//当前页
	private int curPage=1;

	//每页显示
	private int pageSize=10;
	
	//记录总数
	private int total;

	public Pager(int curPage, int pageSize) {
		super();
		this.curPage = curPage;
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (curPage-1)*pageSize;
	}

	public int getEnd() {
		return curPage*pageSize;
	}
	

}
