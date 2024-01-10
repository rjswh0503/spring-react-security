package com.kh.api.login.naver.dto;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NaverDTO {
	private String id;
	private String email;
	private String name;
	private String nickname;
	private String mobile;
	private String birthday;
	private String age;
	private String gender;
	
	

}
