package com.jsp.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoppingCart.DAO.ProductDao;
import com.jsp.ShoppingCart.DTO.Product;

@RestController
public class ProductController {
	@Autowired
	ProductDao dao;
	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product)
	{
		String message=dao.addProduct(product);
		return message;
	}
	@GetMapping("/product")
	public List<Product> findAll()
	{
		return dao.getAllProducts() ;
		
	}
	
	@GetMapping("/productid")
	public Product getProductById(@RequestParam int id)
	{
	return	dao.findProductById(id);
	}
	
	@DeleteMapping("/product")
	public String deleteProduct(@RequestParam int id)
	{
		return dao.deleteProduct(id);
	}
	
	@PutMapping("/product")
	public Product updateById(@RequestParam int id,@RequestParam int quantity)
	{
		return dao.updateById(id, quantity);
	}
	

}
