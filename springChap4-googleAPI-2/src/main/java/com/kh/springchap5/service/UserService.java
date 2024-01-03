package com.kh.springchap5.service;

import com.kh.springchap5.model.UserGoogle;

public interface UserService {
	UserGoogle findByUsername(String username);
	void saveUser(UserGoogle user);

}
