package com.gm.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long perPage; //perPage : 한 페이지당 출력할 글의 갯수
	private Long perBlock; //perBlock : 한 페이지당 출력할 번호의 갯수
	private Long startRow; //mapper에서 꺼내서 사용할 변수
	private Long lastRow; //mapper에서 꺼내서 사용할 변수

	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	// 만약 페이지에 글이 없거나 10개 이하라면 페이지 1개로
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		
		return page;
	}
	
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		
		return perPage;
	}
	
	public void getRowNum() throws Exception {
		this.startRow = (this.getPage() - 1) * this.getPerPage();
		this.lastRow =(this.getPage() * this.getPerPage());
	}
	
}
