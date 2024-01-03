package com.kh.springchap4googleAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap4googleAPI.model.MemberGoogle;

public interface MemberGoogleRepository extends JpaRepository<MemberGoogle, Long> {
	MemberGoogle findByUserName(String username);
	
	
	
	

}
