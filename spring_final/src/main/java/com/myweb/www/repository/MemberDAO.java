package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.security.AuthVO;
import com.myweb.www.security.MemberVO;

public interface MemberDAO {

	int updateLastLogin(String authEmail);

	MemberVO selectEmail(String username);


	List<AuthVO> selectAuth(String username);

	int insert(MemberVO mvo);

	int insertAuth(String email);

	List<MemberVO> selctList();

	List<AuthVO> authlist(String email);

	MemberVO getdetail(String email);

	int modifyPwdEmpty(MemberVO mvo);

	int modify(MemberVO mvo);

	int delete(String email);
}
