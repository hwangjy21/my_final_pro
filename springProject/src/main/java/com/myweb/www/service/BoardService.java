package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO boardDTO);

	List<BoardVO> getList(PagingVO pagingVO);

	BoardDTO getDetail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int getTotalCount(PagingVO pagingVO);

	BoardDTO getDetailFile(long bno);

	int modifyFiles(BoardDTO bdto);

	int delete_f(String uuid);

	/* FileVO getDetail_f(int bno); */

}
