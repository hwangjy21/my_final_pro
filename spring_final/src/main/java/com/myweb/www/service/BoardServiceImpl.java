package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.CommentDAO;
import com.myweb.www.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO bdao;

	@Inject
	private FileDAO fdao;
	
	@Inject
	private CommentDAO cdao;

	@Override
	public int insert(BoardDTO boardDTO) {
		int isUp = bdao.insert(boardDTO.getBvo());
		if (boardDTO.getFlist() == null) {
			isUp *= 1;
			return isUp;
		}

		if (isUp > 0 && boardDTO.getFlist().size() > 0) {
			long bno = bdao.selectOneBno();

			for (FileVO fvo : boardDTO.getFlist()) {
				fvo.setBno(bno);
				isUp *= fdao.insertFile(fvo);
			}
		}
		return isUp;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
	List<BoardVO> list = bdao.list(pgvo);
	for(BoardVO bvo : list) {
		bdao.getListComment(bvo);
		bdao.getListFile(bvo);
		
	}
		return list;
	}

	/*
	 * @Override public BoardDTO getDetail(long bno) { bdao.readCount(bno, 1);
	 * 
	 * BoardDTO bdto = new BoardDTO(bdao.getDetil(bno), fdao.getFileList(bno));
	 * return bdto; }
	 */

	@Override
	public int remove(long bno) {	
		int isOk = cdao.removeCommentAll(bno);
		isOk *=fdao.removeFileAll(bno);
		
		return bdao.remove(bno);
	}

	@Override
	public int modify(BoardDTO boardDTO) {
		bdao.readCount(boardDTO.getBvo().getBno(), -2);
		int isUp = bdao.modify(boardDTO.getBvo());
		if (boardDTO.getFlist() == null) {
			isUp *= 1;
			return isUp;
		}

		if (isUp > 0 && boardDTO.getFlist().size() > 0) {
			long bno = bdao.selectOneBno();

			for (FileVO fvo : boardDTO.getFlist()) {
				fvo.setBno(bno);
				isUp *= fdao.insertFile(fvo);
			}
		}
		return isUp;
	}

	@Override
	public BoardDTO getDetil(long bno) {
		bdao.readCount(bno, 1);

		BoardDTO bdto = new BoardDTO(bdao.getDetil(bno), fdao.getFileList(bno));
		return bdto;
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.totalCount(pgvo);
	}

	@Override
	public int remveFile(String uuid) {
		
		return fdao.removeFile(uuid);
	}

	@Override
	public String getBoardWriter(long bno) {
		// TODO Auto-generated method stub
		return bdao.writer(bno);
	}
	}
