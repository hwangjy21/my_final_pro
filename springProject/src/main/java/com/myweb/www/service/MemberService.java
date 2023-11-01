package com.myweb.www.service;

import java.util.List;

import com.myweb.www.security.AuthVO;
import com.myweb.www.security.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	boolean updateLastLogin(String authEmail);

	List<MemberVO> getList(MemberVO mvo);
	/*
	 * Object getList_a(AuthVO auth);
	 */

	MemberVO getDetail(String email);

	int modify(MemberVO mvo);

	int remove(String email);

	/*
	 * List<AuthVO> getList_a(AuthVO auth);
	 */
}