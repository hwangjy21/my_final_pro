package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.repository.MemberDAO;
import com.myweb.www.security.AuthVO;
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
	public List<MemberVO> selectList() {
		List<MemberVO> list = mdao.selctList();
	for(MemberVO mvo : list) {
		mvo.setAuthList(mdao.selectAuth(mvo.getEmail()));
	}
	return list;

	}

	@Override
	public MemberVO getdetail(String email) {
		// TODO Auto-generated method stub
		return mdao.getdetail(email);
	}

	@Override
	public int modifyPwdEmpty(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.modifyPwdEmpty(mvo);
	}

	@Override
	public int modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.modify(mvo);
	}

	@Override
	public int remove(String email) {
		// TODO Auto-generated method stub
		return mdao.delete(email);
	}



}
