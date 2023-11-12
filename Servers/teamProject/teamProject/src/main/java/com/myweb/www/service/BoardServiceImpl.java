package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.www.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardDAO bdao;

	@Autowired
	public BoardServiceImpl(BoardDAO bdao) {
		this.bdao = bdao;
	}
	
	
}
