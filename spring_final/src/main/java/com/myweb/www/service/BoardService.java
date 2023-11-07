package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardService {

	int insert(BoardDTO boardDTO);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetil(long bno);



	int remove(long bno);

	int modify(BoardDTO boardDTO);

	int getTotalCount(PagingVO pgvo);

	int remveFile(String uuid);

	String getBoardWriter(long bno);

}

