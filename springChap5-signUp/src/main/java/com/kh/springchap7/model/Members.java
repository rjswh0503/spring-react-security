package com.kh.springchap7.model;

import java.util.Date;

import lombok.*;

@Getter
@Setter
public class Members {
	private Long memberID;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private Date registrationDate;
	

}
