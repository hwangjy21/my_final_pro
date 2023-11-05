package com.myweb.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService bsv;
	@Inject
	private FileHandler fh;

	@GetMapping("register")
	public void register() {
		log.info(">>>로그인서비스 들어옴");

	}

	@PostMapping("register")
	public String register(BoardVO bvo, RedirectAttributes re,
			@RequestParam(name = "files", required = false) MultipartFile[] files) {

		log.info(">>>>>bvo>>files>>" + bvo + " /" + files);

		List<FileVO> flist = null;
		if (files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
			log.info(">>>>>flist" + flist);
		}

		int isUp = bsv.insert(new BoardDTO(bvo, flist));

		return "index";
	}

	@GetMapping("list")
	public void list(Model m, BoardVO bvo) {

		m.addAttribute("list", bsv.getList(bvo));

	}

	@GetMapping({ "detail", "modify" })
	public void deiail(Model m, @RequestParam("bno") long bno) {

		m.addAttribute("bdto", bsv.getDetil(bno));

	}

	@PostMapping("/modify")
	public String modify(RedirectAttributes re, BoardVO bvo,@RequestParam(name = "files", required = false) MultipartFile[] files) {

		List<FileVO> flist = null;
		if (files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
			log.info(">>>>>flist" + flist);
		}

		int isOk = bsv.modify(new BoardDTO(bvo,flist));
		re.addAttribute("bno", bvo.getBno());
		re.addAttribute("isMod", isOk);
		return "redirect:/board/detail";
	}

	@GetMapping("remove")
	public String remove(RedirectAttributes re, @RequestParam("bno") long bno,
			@RequestParam(name = "files", required = false) MultipartFile[] files) {

		int remove = bsv.remove(bno);

		re.addFlashAttribute("isDel", remove);
		return "redirect:/board/list";
	}

}
