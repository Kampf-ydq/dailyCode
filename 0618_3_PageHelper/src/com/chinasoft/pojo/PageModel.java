package com.chinasoft.pojo;

import java.util.List;

/*
 * ��������ҳ�йص�����
 */
public class PageModel {

	//�����
	private List list;
	//�ܼ�¼��
	private int total;
	//ҳ������
	private int pageSize;
	//ҳ��
	private int pageNo;
	
	/*
	 * ��ҳ��
	 */
	public int getTaotalPage(){
		return (total+pageSize-1)/pageSize;
	}
	
	/*
	 * ��ȡ��ҳ
	 */
	public int getTopPageNo(){
		return 1;
	}
	
	/*
	 * ��ȡβҳ
	 */
	public int getBottomPageNo(){
		return getTaotalPage();
	}
	
	/*
	 * ��һҳ
	 */
	public int getPrePageNo(){
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}
	
	/*
	 * ��һҳ
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
