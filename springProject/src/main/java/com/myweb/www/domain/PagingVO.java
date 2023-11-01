package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Setter
@Getter
@Slf4j
public class PagingVO {
	private int pageNo;
	private int qty;
	private String type; //검색 처리용
	private String keyword;
	public PagingVO() {
		this(1,10);
	}
	public PagingVO(int pageNo, int qty) {
		this.pageNo =pageNo;
		this.qty=qty;
	}
	
	//limit 시작,qty : 시작페이지 번호 구하기
	//pageNO 1 2 3 4
	//0,10/10,10/20,10....

	public int getPageStart() {
		//DB상에서 limit의 시작값을 구하는 메서드
		//limit는 0부터 시작 10개씩.  limit 0, 10
		return (this.pageNo-1)*qty;
	}
	
	
	//타입의 형태를 여러가지 형태로 복합적인 검색을 하기위해서
	//타입의 키워드 t,c,w,tc,tw,cw,tcw
	
	//복합타입을 배열로 나누기 위해서
	public String[] getTypeToArrary() {
		return this.type == null? new String[] {}: this.type.split("");
		
		
	}

	
}