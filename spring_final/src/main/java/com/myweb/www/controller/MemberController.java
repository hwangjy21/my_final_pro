package com.myweb.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.security.MemberVO;
import com.myweb.www.service.MemberService;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/**")
public class MemberController {
	
	@Inject
	private BCryptPasswordEncoder bcEncoder;

	@Inject
	private MemberService msv;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(MemberVO mvo) {
		
		mvo.setPwd(bcEncoder.encode(mvo.getPwd()));
		log.info(">>>>> register >> mvo {} >" + mvo);
		int isOk =msv.register(mvo);
		return "index";
		
	}
	@GetMapping("/login")
	public void login() {
		
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes re) {
		log.info(">>>>> errMsg >> "+request.getAttribute("errMsg"));
		re.addAttribute("email", request.getAttribute("email"));

		re.addAttribute("errMsg", request.getAttribute("errMsg"));
		return "redirect:/member/login";
	}
	
	
	
	

	@GetMapping("/list")
	public void memberList(Model m) {
		m.addAttribute("memList", msv.selectList());
	}
	

	
	
	
}
