package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.Repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository repository;
	
	public String addProduct(Product product)
	{
		repository.save(product);
		return "product is added successfully";
	}
	public List<Product> getAllProducts()
	{
	return repository.findAll();
		
	}
	
	public Product findProductById(int id)
	{
	Optional<Product> opt=repository.findById(id);
	if(opt.isPresent())
	{
		return opt.get();
	}
	return null;
	
	
		
	}
	//delete an object from the database
	
	public String deleteProduct(int id)
	{
	Product p=	findProductById(id);
	if(p!=null)
	{
		String ProductName=p.getProductName();
		repository.delete(p);// repository.deleteById(P0;
		return ProductName+"product removed from cart";
	}
	return "product not available in cart";
	}
	
	//upadate based on id
	public Product updateById(int id, int newQuantity)
	{
		Product p=	findProductById(id);
		if(p!=null)
		{
			p.setQuantity(newQuantity);
			repository.save(p);
			return p;
		}
		return null;
	}

}
