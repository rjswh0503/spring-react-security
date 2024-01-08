package com.kh.springchap7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springchap7.mapper.MembersMapper;
import com.kh.springchap7.model.Members;

@Service
public class MemberService {
	
	@Autowired
	private MembersMapper membersMapper;
	
	
	
	
	public List<Members> getAllMembers() {
		return membersMapper.getAllMembers();
		
	}
	
	
	
	//회원 정보 저장하기
	public void SignUpMember(Members members) {
		membersMapper.insertMember(members);
	
	}
	
	public Members getMemberById(Long id) {
		return membersMapper.getMemberById(id);
	}
	
	
	public void MemberUpdate(Members members) {
		membersMapper.updateMember(members);
	}
	
	
	public void deleteMember(Long id) {
		membersMapper.deleteMember(id);
	}
	

}
