package com.kh.springchap7.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springchap7.model.Members;

@Controller
public class SNSController {
	
	@GetMapping("/oauth2/authorization/naver")
	public String naverLogin() {
		return "redirect:/login/oauth2/code/naver";
	}
	
	@GetMapping("/login/ouath2/code/naver")
	public String naverLoginCallback() {
		Members naverMember = new Members();
		naverMember.setEmail("email");
		naverMember.setFullName("name");
		naverMember.setUsername("");
		model.addAttribute("members", naverMember);
		return "register";
	}

}
