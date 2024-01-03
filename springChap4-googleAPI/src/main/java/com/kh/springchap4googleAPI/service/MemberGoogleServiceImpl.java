package com.kh.springchap4googleAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springchap4googleAPI.model.MemberGoogle;
import com.kh.springchap4googleAPI.repository.MemberGoogleRepository;

@Service

public class MemberGoogleServiceImpl implements MemberGoogleService {
	private final MemberGoogleRepository memberGoogleRepository;
	
	
	@Autowired
	public MemberGoogleServiceImpl(MemberGoogleRepository memberGoogleRepository) {
		this.memberGoogleRepository = memberGoogleRepository;
	}
	
	@Override
	public MemberGoogle findByUserName(String username) {
		return memberGoogleRepository.findByUserName(username);
	}
	
	@Override
	public void saveMember(MemberGoogle user) {
		memberGoogleRepository.save(user);
		
	}
	
	
	
	
	
	
	
	

}
