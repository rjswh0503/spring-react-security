package com.kh.springchap7.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springchap7.model.Members;

@Mapper
public interface MembersMapper {
	void insertMember(Members members);
	List<Members> getAllMembers();
	 Members getMemberById(Long id);
	void updateMember(Members members);
	void deleteMember(Long id);
	
	
	

}
