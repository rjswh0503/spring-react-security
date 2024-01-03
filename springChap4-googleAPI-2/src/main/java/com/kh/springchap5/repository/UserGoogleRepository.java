package com.kh.springchap5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap5.model.UserGoogle;

public interface UserGoogleRepository extends JpaRepository<UserGoogle, Long> {

	UserGoogle findByUsername(String username);
}
