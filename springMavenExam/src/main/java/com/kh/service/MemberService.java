package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dao.MemberDAO;
import com.kh.vo.MemberVo;

@Service
public class MemberService {
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	public MemberVo loginMember(String memberId, String memberPwd) {
		memberDAO.loginMember(memberId, memberPwd);
		
		
		
	}
	
	
	
	

}




@Service
public class MemberService

@Autowired
private MemberDAO memberDAO;

public MemberVo loginMember(String memberId, String memberPwd) {
	memberDAO.loginMember(memeberId, memberPwd);
}




