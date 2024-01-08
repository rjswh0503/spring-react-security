package com.kh.springchap5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springchap5.model.UserGoogle;

@Mapper
public interface GoogleUser {
	
	
	List<UserGoogle> getUser();
	

}
