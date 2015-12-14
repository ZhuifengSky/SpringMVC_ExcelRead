package com.main.common.bean;

import java.util.List;


public class Page<T> {

	private PageBean pageBean;
	private List<T> data;
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
	
	
}
