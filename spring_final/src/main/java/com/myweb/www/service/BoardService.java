package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;

public interface BoardService {

	int insert(BoardDTO boardDTO);

	List<BoardVO> getList(BoardVO bvo);

	BoardDTO getDetil(long bno);



	int remove(long bno);

	int modify(BoardDTO boardDTO);

}
