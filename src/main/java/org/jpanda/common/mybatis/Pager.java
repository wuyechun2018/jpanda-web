package org.jpanda.common.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {
	private static final long serialVersionUID = -9067418025524889604L;
	//每页显示几条
	private int size = 15;
	//总条数
	private int total = 0;
	//当前页
	private int currentPage = 0;
	//总页数
	private int totalPage;
	//当前记录起始索引
	private int currentResult = 0;
	//存放结果集
	private List<T> result = new ArrayList<T>();


	public Pager() {

	}

	public Pager(int TOTAL, int CURRENTPAGE, int TOTALPAGE) {
		setTotal(TOTAL);
		setTotalPage(TOTALPAGE);
		setCurrentPage(CURRENTPAGE);
	}

	/***
	 * 
	 * 功能 :初始化分页对象	
	 * 开发：ycwu 2014-11-21	
	 * @param start
	 * @param limit
	 * @return
	 */
	public static <T> Pager<T> getInitPager(int start, int limit) {
		Pager<T> page = new Pager<T>();
		page.setCurrentResult(start);
		page.setSize(limit);
		return page;
	}
	
	/**
	 * 获取结果集
	 */
	public List<T> getResult() {
		if (result == null) {
			return new ArrayList<T>();
		}
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 获取总页数
	 */
	public int getTotalPage() {
		if (total % size == 0) {
			totalPage = total / size;
		} else {
			totalPage = total / size + 1;
		}
		return totalPage;
	}

	/**
	 * 获取总条数
	 */
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		currentPage=currentResult/size+1;
		if (currentPage <= 0) {
			currentPage = 1;
		}
		if (currentPage > getTotalPage()) {
			currentPage = getTotalPage();
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size == 0) {
			size = 15;
		}
		this.size = size;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getSize();
		if (currentResult < 0) {
			currentResult = 0;
		}
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
