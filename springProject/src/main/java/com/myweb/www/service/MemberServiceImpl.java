package com.myweb.www.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.repository.MemberDAO;
import com.myweb.www.security.AuthVO;
import com.myweb.www.security.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO mdao;

	@Transactional
	@Override
	public int register(MemberVO mvo) {
		log.info("회원가입 서비스 들어옴");
		int isOk = mdao.insert(mvo);
		return mdao.insertAuthInit(mvo.getEmail());

	}

	@Override
	public boolean updateLastLogin(String authEmail) {

		return mdao.updateLastLogin(authEmail) > 0 ? true : false;

	}

	@Transactional
	@Override
	public List<MemberVO> getList(MemberVO mvo) {
	    // DAO 메서드 호출
	    List<MemberVO> memberList = mdao.list(mvo);
	    
	    for (MemberVO member : memberList) {
	        // 각 멤버별 권한 목록 설정
	        member.setAuthList(mdao.getList_a(member));
	    }

	    return memberList;
	}


	/*
	 * @Override public List<AuthVO> getList_a(AuthVO auth) { // TODO Auto-generated
	 * method stub return mdao.getList_a(auth); }
	 */
	@Transactional
	@Override
	public MemberVO getDetail(String email) {

		MemberVO mvo = mdao.getDetail(email);
		mvo.setAuthList(mdao.getDetail_ab(email));

		return mvo;
	}

	@Override
	public int modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mdao.modify(mvo);
	}

	@Override
	public int remove(String email) {
		mdao.delete_a(email);
		return mdao.delete(email);
	}
}
