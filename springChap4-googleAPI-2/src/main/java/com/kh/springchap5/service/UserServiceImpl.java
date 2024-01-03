package com.kh.springchap5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springchap5.model.UserGoogle;
import com.kh.springchap5.repository.UserGoogleRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserGoogleRepository userGoogleRepository;
	@Autowired
	public UserServiceImpl(UserGoogleRepository userGoogleRepository) {
		
	
	this.userGoogleRepository = userGoogleRepository;
}

	@Override
	public UserGoogle findByUsername(String username) {
		return userGoogleRepository.findByUsername(username);
	}
	
	@Override
	public void saveUser(UserGoogle user) {
		userGoogleRepository.save(user);
	}

}