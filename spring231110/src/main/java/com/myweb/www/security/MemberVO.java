package com.myweb.www.security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class MemberVO {
	private long empNo;
	private String id;
	private String pw;
	private String addr;
	private String phone;
	private String depCd;
	private String empNm;
	private String empBirth;
	private String lastLogin;
	private List<AuthVO> authVOList;
	
}
