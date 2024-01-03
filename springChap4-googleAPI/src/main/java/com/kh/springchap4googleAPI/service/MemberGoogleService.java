package com.kh.springchap4googleAPI.service;

import com.kh.springchap4googleAPI.model.MemberGoogle;

public interface MemberGoogleService {
	MemberGoogle findByUserName(String username);
	void saveMember(MemberGoogle user);

}
