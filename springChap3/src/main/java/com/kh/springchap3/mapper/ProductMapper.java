package com.kh.springchap3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springchap3.model.Product;

//JpaRepository
@Mapper
public interface ProductMapper {
	//src/main/resources/mapper/ProductMapper.xml
	//밑에 작성해준 sql문 id만 작성할 것
	//JPA처럼 mapper.xml 파일에는 작성하지 않은 sql문과 id에 관련된 메서드를 모두 작성해주면 애러남
	
	List<Product> getAllProduct();
	
	
	void insertProduct(Product product);

}
