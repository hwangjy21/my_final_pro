package com.myweb.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> list(BoardVO bvo);

	BoardVO getDetil(long bno);

	int modify(BoardVO bvo);

	void readCount(@Param("bno")long bno, @Param("cnt")int cnt);

	int remove(long bno);

	long selectOneBno();

	int totalCount(PagingVO pgvo);

	List<BoardVO> list(PagingVO pgvo);

}
