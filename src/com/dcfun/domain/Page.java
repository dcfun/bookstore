package com.dcfun.domain;

import java.util.List;

public class Page {

	private int totalpage;			//总页数
	private int pagesize = 3;		//页面大小
	
	private int totalrecord;		//总记录数
	private int pagenum;			//当前页数 
	
	private int startindex;			//记住用户想看的页的数据是从哪个地方取的
	
	private List list;				//当前页面数据
	
	private int startPage;
	private int endPage;
	
	public Page(int pagenum, int totalrecord){
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		
		//算出 总页数
		this.totalpage = (this.totalrecord+this.pagesize-1)/this.pagesize;
		//算出用户想看的也的数据是从数据库的哪个地方去的
		this.startindex = (this.pagenum-1)*this.pagesize;
		//算 startPage和endPage
		if (this.totalpage<=10) {
			this.startPage = 1;
			this.endPage = this.totalpage;
		}else {
			this.startPage = this.pagenum - 4;
			this.endPage = this.pagenum + 5;
			
			if (this.startPage<1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.startPage > this.totalpage) {
				this.startPage = this.totalpage - 9;
				this.endPage = this.totalpage;
			}
		}
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
