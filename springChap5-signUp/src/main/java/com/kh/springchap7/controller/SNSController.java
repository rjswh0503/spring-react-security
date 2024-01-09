package com.kh.springchap7.controller;



import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springchap7.model.Members;

@Controller
public class SNSController {
	
	@GetMapping("/oauth2/authorization/naver")
	public String naverLogin() {
		return "redirect:/login/oauth2/code/naver";
	}
	
	@GetMapping("/login/ouath2/code/naver")
	public String naverLoginCallback(@AuthenticationPrincipal OAuth2User oauth2User, Model model) {
		Object response = oauth2User.getAttribute("response");
		// 객체가 인스턴스인지 아닌지를 판한하는 것
		// oauth2 인증에서는 사용자 정보가 맵과 유사한 구조로 캡슐화
		// response로 값을 가지고 오는데  Map에 인스턴스인지를 확인해보는 것
		// 만약에 response가 Map에 구조로 돼있다면 email이나 name의 정보를 추출해서 원하는 정보를 가지고 오겠다는 의미
		if(response instanceof Map) {
			Map<String, Object> responseMap = (Map<String, Object>) response;
			String email = (String) responseMap.get("email");
			String name = (String) responseMap.get("name");
			
			
			Members naverMember = new Members();
			naverMember.setEmail("email");
			naverMember.setFullName("name");
			naverMember.setUsername("");
			model.addAttribute("members", naverMember);
			return "register";
			
			
		}else {
			return "redirect:/error";
		}
		
	}

}
