package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
@Inject
private CommentDAO cdao;

@Override
public int insert(CommentVO cvo) {
	// TODO Auto-generated method stub
	return cdao.insert(cvo);
}
@Transactional
@Override
public PagingHandler getList(long bno, PagingVO pgvo) {

	int totoalCount = cdao.selectOnBnoTotalCount(bno);
	log.info(">>>>서비스 리스트>>bno"+bno);
	log.info(">>>>>pageVO>>>"+pgvo);
	List<CommentVO> list = cdao.selectListPaging(bno,pgvo);
	log.info(">>>>>list>>>"+list);
	PagingHandler ph = new PagingHandler(pgvo, totoalCount,list);
	return ph;
}
@Override
public int modify(CommentVO cvo) {
	// TODO Auto-generated method stub
	return cdao.update(cvo);
}
@Override
public int remove(long cno) {
	// TODO Auto-generated method stub
	return cdao.delete(cno);
}
}
