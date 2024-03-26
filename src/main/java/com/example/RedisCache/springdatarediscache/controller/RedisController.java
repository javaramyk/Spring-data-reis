package com.example.RedisCache.springdatarediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedisCache.springdatarediscache.entity.Product;
import com.example.RedisCache.springdatarediscache.repository.ProductDAO;

@RestController
@RequestMapping("/redis/product")
public class RedisController {

	@Autowired
	private ProductDAO productDAO;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return productDAO.save(product);
	}
	
	@GetMapping("/findAll")
	public List<Product> findProduct() {
		return productDAO.findAll();
	}
	@GetMapping("/findAll/{id}")
	public Product findProductById(@PathVariable int id) {
		return productDAO.findProductById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable int id) {
		return productDAO.deleteProduct(id);
	}
}
