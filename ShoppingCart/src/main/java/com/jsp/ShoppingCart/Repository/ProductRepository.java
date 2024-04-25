package com.jsp.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ShoppingCart.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
