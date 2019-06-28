package com.chinasoft.pojo;

import java.util.List;

/*
 * 创建跟分页有关的内容
 */
public class PageModel {

	//结果集
	private List list;
	//总记录数
	private int total;
	//页面容量
	private int pageSize;
	//页码
	private int pageNo;
	
	/*
	 * 总页数
	 */
	public int getTaotalPage(){
		return (total+pageSize-1)/pageSize;
	}
	
	/*
	 * 获取首页
	 */
	public int getTopPageNo(){
		return 1;
	}
	
	/*
	 * 获取尾页
	 */
	public int getBottomPageNo(){
		return getTaotalPage();
	}
	
	/*
	 * 上一页
	 */
	public int getPrePageNo(){
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}
	
	/*
	 * 下一页
	 */
	public int getNextPageNo(){
		if (pageNo >= getBottomPageNo()) {
			return getBottomPageNo();
		}
		return pageNo + 1;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
