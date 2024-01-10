package com.kh.api.login.naver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.login.common.MsgEntity;
import com.kh.api.login.naver.dto.NaverDTO;
import com.kh.api.login.naver.service.NaverService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/naver")
public class NaverController {
	private final NaverService naverService;
	
	// 결과에 대한 내용을 담을 Entity
	@GetMapping("/callback")
	public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception {
		
		NaverDTO naverInfo = naverService.getNaverInfo(request.getParameter("code"));
		
		return ResponseEntity.ok()
				.body(new MsgEntity("Success", naverInfo));
				
	}
}
