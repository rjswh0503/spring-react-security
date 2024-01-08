package com.kh.springchap6.Repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap6.model.UserSNS;

public interface UserRepository extends JpaRepository<UserSNS, Long> {
	
	

}
