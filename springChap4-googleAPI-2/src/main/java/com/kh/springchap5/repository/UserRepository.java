package com.kh.springchap5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap5.model.UserGoogle;

public interface UserRepository extends JpaRepository<UserGoogle, Long> {
	Optional<UserGoogle> findByUsername(String username);

}
