package com.kh.springchap1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userd_seq")
	@SequenceGenerator(name="userd_seq", sequenceName="userd_seq", allocationSize=1)
	private Long id;
	private String username;
	private String email;
	
	
	

}
