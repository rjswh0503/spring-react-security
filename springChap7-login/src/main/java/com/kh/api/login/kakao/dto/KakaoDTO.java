package com.kh.api.login.kakao.dto;

import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//데이터를 전송하는 속성
// DAO는 읽기만 함
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class KakaoDTO {
	
	
	private long id;
	private String email;
	private String nickname;
	private String birthyear;
	private String gender;

}
