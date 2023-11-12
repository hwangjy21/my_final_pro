package com.myweb.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {

	private BoardService bsv;

	@Autowired
	public BoardController(BoardService bsv) {
		this.bsv = bsv;
	}
	
	@GetMapping("/writer")
	public void getWriter() {}
	
	@GetMapping("/tables")
	public void tables() {}
	
	@GetMapping("/anonymousBoard")
	public void anonymousBoardList() {
		
	}
}
