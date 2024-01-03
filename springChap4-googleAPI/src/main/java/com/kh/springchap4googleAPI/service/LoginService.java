package com.kh.springchap4googleAPI.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	//만약에 회원가입이나 로그인을 할 떄 들어갈 수 있는 코드가 있다면 입장
	// 코드가 없다면 입장 못하게 할 것
	
	public void socialLogin(String code, String registrationId) {
		System.out.println("code : " + code);
		System.out.println("regist ID : " + registrationId);
		
		
		
		
	}

}
