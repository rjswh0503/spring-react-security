package com.kh.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.vo.MemberVo;

//MemberMapper
@Mapper
public interface MemberDAO {
	MemberVo loginMember(String memberId, String memberPwd);
	
	

}


//MemberMapper
@Mapper
public interface MemberMapper {
	MemberVo loginMember(String memberId, String memberPwd);
}
