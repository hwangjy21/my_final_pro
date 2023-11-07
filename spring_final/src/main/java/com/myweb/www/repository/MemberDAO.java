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
}
