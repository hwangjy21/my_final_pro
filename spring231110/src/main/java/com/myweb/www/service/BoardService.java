package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;


public interface BoardService {

//	int write(BoardVO bvo);

	List<BoardVO> getList();

//	BoardVO detail(long bno);

//	int modify(BoardVO bvo);

	BoardVO SelectOneForModify(long bno);

	int remove(long bno);

	List<BoardVO> getList(PagingVO pagingVO);

	int getTotalCount(PagingVO pagingVO);

	int write(BoardDTO boardDTO);

	List<FileVO> getFileList(long bno);

	BoardDTO detail2(long bno);

	int removefile(String uuid);

	int modifyFile(BoardDTO bdto);

}
