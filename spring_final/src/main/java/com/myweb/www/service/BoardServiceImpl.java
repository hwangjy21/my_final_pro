package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
@Inject
private BoardDAO bdao;

@Override
public int insert(BoardVO bvo) {
	// TODO Auto-generated method stub
	return bdao.insert(bvo);
}

@Override
public List<BoardVO> getList(BoardVO bvo) {
	// TODO Auto-generated method stub
	return bdao.list(bvo);
}

@Override
public BoardVO getDetil(long bno) {
	bdao.readCount(bno,1);
	return bdao.getDetil(bno);
}

@Override
public int modify(BoardVO bvo) {
	bdao.readCount(bvo.getBno(),-2);
	return bdao.modify(bvo);
}

@Override
public int remove(long bno) {
	// TODO Auto-generated method stub
	return bdao.remove(bno);
}
}
