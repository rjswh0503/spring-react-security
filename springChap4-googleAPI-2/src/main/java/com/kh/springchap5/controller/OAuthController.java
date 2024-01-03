package com.kh.springchap5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springchap5.model.UserGoogle;
import com.kh.springchap5.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class OAuthController {
	
	 @Autowired
	 private UserService userService;
	 @GetMapping("/loginSuccess")
	 public String loginSuccess(@AuthenticationPrincipal OAuth2User oauthUser, Model model) {
	     String email = oauthUser.getAttribute("email");
	     UserGoogle user = userService.findByUsername(email);

	     if (user == null) {
	         user = new UserGoogle();
	         user.setUsername(email);
	         user.setEmail(email);
	         userService.saveUser(user);

	         model.addAttribute("newUser", true);
	     }

	   
	     return "loginSuccess";
	 }
	     
     @GetMapping("/logout")
     public String logout(HttpServletRequest request, HttpServletResponse response) {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         if (auth != null) {
             new SecurityContextLogoutHandler().logout(request, response, auth);
         }
         return "redirect:/";
     }
	

}
