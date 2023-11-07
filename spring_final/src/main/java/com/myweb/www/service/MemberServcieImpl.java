package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.repository.MemberDAO;
import com.myweb.www.security.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServcieImpl implements MemberService {
	@Inject
	private MemberDAO mdao;

	@Override
	public boolean updateLastLogin(String authEmail) {
		return mdao.updateLastLogin(authEmail)>0?true:false;
		
	}

	@Override
	public int register(MemberVO mvo) {
	int isOk = mdao.insert(mvo);
		return mdao.insertAuth(mvo.getEmail());
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
