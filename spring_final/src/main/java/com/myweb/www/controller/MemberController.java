package com.myweb.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tika.sax.SecureContentHandler;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.security.MemberVO;
import com.myweb.www.service.MemberService;

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
		int isOk = msv.register(mvo);
		return "index";

	}

	@GetMapping("/login")
	public void login() {

	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes re) {
		log.info(">>>>> errMsg >> " + request.getAttribute("errMsg"));
		re.addAttribute("email", request.getAttribute("email"));

		re.addAttribute("errMsg", request.getAttribute("errMsg"));
		return "redirect:/member/login";
	}

	@GetMapping("/list")
	public void memberList(Model m) {
		m.addAttribute("memList", msv.selectList());
	}

	@GetMapping({ "/detail", "/modify" })
	public void detail(Model m, @RequestParam("email") String email) {
		m.addAttribute("mem", msv.getdetail(email));
	}

	@PostMapping("/modify")
	public String modify(MemberVO mvo, Model m, HttpServletRequest req, HttpServletResponse res) {
		int isOk = 3;

		if (mvo.getPwd().isEmpty()) {
			isOk = msv.modifyPwdEmpty(mvo);
		} else {
			mvo.setPwd(bcEncoder.encode(mvo.getPwd()));
			isOk = msv.modify(mvo);
		}

		logout(res, req);
		m.addAttribute("isOk", isOk);
		return "/member/login";
	}
	
	private void logout(HttpServletResponse res,HttpServletRequest req) {
		Authentication authentication =SecurityContextHolder
				.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(req,res,authentication);
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("email")String email, Model M,HttpServletRequest req, HttpServletResponse res ) {
		int isOk = msv.remove(email);
		logout(res,req);
		M.addAttribute("isOkDel", isOk);
		return "index";
	}
}
