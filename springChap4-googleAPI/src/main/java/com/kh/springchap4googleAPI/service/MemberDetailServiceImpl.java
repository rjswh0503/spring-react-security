package com.kh.springchap4googleAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.springchap4googleAPI.model.MemberGoogle;
import com.kh.springchap4googleAPI.repository.MemberGoogleRepository;

@Service
public class MemberDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private MemberGoogleRepository memberGoogleRepository;
	
	public UserDetails loadUsername(String username) throws UsernameNotFoundException {
		MemberGoogle user = memberGoogleRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("일치하는 유저 정보를 찾을 수 엇습니다." + username));
		
		/*
		return new org.springframework.security.userdetails.User(
				user.getUsername(),
				"", //비밀번호  Oauth 인증에서는 사용하지 않음
				Collextions.emptyList());
				
		*/
	}
	

}
