package com.myweb.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService bsv;
	
	@GetMapping("register")
	public void register() {
		log.info(">>>로그인서비스 들어옴");
		
	
	}
	
	@PostMapping("register")
	public String register(BoardVO bvo, RedirectAttributes re) {
		
		
		log.info(">>>>>bvo>>"+bvo);
		int isUp = bsv.insert(bvo);
		
		return "index";
	}
	
	
	@GetMapping("list")
	public void list(Model m,BoardVO bvo) {
		
		m.addAttribute("list",bsv.getList(bvo));
		
	}
	
	
	
	@GetMapping({"detail","modify"})
	public void deiail(Model m,@RequestParam("bno")long bno) {
		
		m.addAttribute("bvo",bsv.getDetil(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(RedirectAttributes re, BoardVO bvo) {
		int isOk = bsv.modify(bvo);
		re.addAttribute("bno",bvo.getBno());
		re.addAttribute("isMod", isOk);
		return "redirect:/board/detail";
	}
	
	@GetMapping("remove")
	public String remove(RedirectAttributes re,@RequestParam("bno")long bno ) {
		int remove =bsv.remove(bno);
		
		re.addFlashAttribute("isDel", remove);
		return "redirect:/board/list";
	}
	


}
