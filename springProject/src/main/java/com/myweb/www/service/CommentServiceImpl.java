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

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	@Inject
	private CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		log.info("댓글 서비스 들어옴");
		return cdao.insert(cvo);
	}

	/*
	 * @Override public List<CommentVO> getList(int bno) {
	 * log.info("댓글 리스트 서비스 들어옴"); return cdao.getList(bno); }
	 */
	@Override
	public int remove(long cno) {
		log.info("댓글 삭제 서비스 들어옴");
		return cdao.delete(cno);
	}

	@Override
	public int edit(CommentVO cvo) {
		log.info("댓글 수정 서비스 들어옴");
		return cdao.update(cvo);
	}
@Transactional
	@Override
	public PagingHandler getList(long bno, PagingVO pgvo) {
		
		log.info("댓글 리스트 서비스 들어옴");
		//total count 구하기
		int totalCount = cdao.selectOnBnoTotalCount(bno);
		//comment list 찾아오기
		log.info(">>>>>totalCount"+totalCount);
		List<CommentVO> list = cdao.selectListPaging(bno, pgvo);
		log.info(">>>>>list"+list);
		PagingHandler ph = new PagingHandler(pgvo, totalCount, list);
		
		log.info(">>>>>ph"+ph);
		//pagingHandler 값 완성 리턴 값 완성 리천
	

		return ph;
	}
}
