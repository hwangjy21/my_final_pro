package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private long bno;
	private String title; 
	private String content;
	private String writer;
	private String regAt; //db에서는 reg_at
	private String modAt;
	private int readCount;
	private int cmtQty; //231013추가
	private int hasFile; //231013추가
}
