package com.kh.api.login.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MsgEntity {
	
	private String msg;
	private Object result;
	
	
	/*
	public MsgEntity(String msg, Object result) {
		this.msg = msg;
		this.result = result;
		
	}
	*/
	
	

}
