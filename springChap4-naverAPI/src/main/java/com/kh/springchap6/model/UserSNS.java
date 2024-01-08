package com.kh.springchap6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class UserSNS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="usersns_seq")
	@SequenceGenerator(name = "usersns_seq", sequenceName="usersns_seq",allocationSize=1)
	private Long id;
	private String name;
	private String email;
	private String provider;
	

}
