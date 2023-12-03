package com.kh.springchap2.model;

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
@Table(name="productss")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="productds_seq")
	@SequenceGenerator(name="productds_seq", sequenceName="productds_seq",allocationSize=1)
	private Long id;
	private String name;
	private String price;
	

	

}
