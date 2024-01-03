package com.kh.springchap4googleAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springchap4googleAPI.model.MemberGoogle;
import com.kh.springchap4googleAPI.service.MemberGoogleService;

@Controller
@RequestMapping("/oauth")
public class OAuthController {
	@Autowired
	private MemberGoogleService membergoogleservice;
	
	@GetMapping("/loginSuccess")
	public String loginSuccess(@AuthenticationPrincipal OAuth2User oauthUser, Model model) {
		String email = oauthUser.getAttribute("email");
		MemberGoogle user = membergoogleservice.findByUserName(email);
		
		if(user == null) {
			user = new MemberGoogle();
			user.setUsername(email);
			user.setEmail(email);
			membergoogleservice.saveMember(user);
			
			model.addAttribute("newUser", true);
		}
		
		return "loginSuccess";
	}
}
