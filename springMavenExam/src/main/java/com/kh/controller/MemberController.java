package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.service.MemberService;
import com.kh.vo.MemberVo;

@Controller
@RequestMapping("/")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String memberlogin() {
		//로그인할 때 필요한 코드를 작성해주면 됨
		return "redirect:/member/login";
	}
	
	@PostMapping("/login")
	public String login(String memberId, String memberPwd, Model model) {
		MemberVo member = memberService.loginMember(memberId, memberPwd);
		model.addAttribute("member", member);
		return "login";
	}
}



@Controller
@RequestMapping("/")
@Autowired
private MemberService memberService;


@GetMapping("/login")
public String memberlogin() {
	return "redirect:/member/login";
	
}


@PostMapping("/login")
public String login(String memberId, String memberPwd, Model model) {
	MemberVo member = memberService.loginMember(memberId, memberPwd);
	model.addAttribute("loginSuccess", member);
	return "loginSuccess";
	
}


