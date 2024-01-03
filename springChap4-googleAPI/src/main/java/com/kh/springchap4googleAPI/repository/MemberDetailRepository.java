package com.kh.springchap4googleAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap4googleAPI.model.Member;
import com.kh.springchap4googleAPI.model.MemberGoogle;

public interface MemberDetailRepository extends JpaRepository<Member, Long> {
	Optional<MemberGoogle> findByUserName(String username);
	
	

}
