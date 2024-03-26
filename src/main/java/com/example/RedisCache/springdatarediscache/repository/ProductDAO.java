package com.example.RedisCache.springdatarediscache.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.RedisCache.springdatarediscache.entity.Product;

@Repository
public class ProductDAO {
  public static final String HASH_VALUE = "Product";
  
  @Autowired
  private RedisTemplate template;
  
  public Product save(Product product) {
	  template.opsForHash().put(HASH_VALUE, product.getId(), product);
	  return product;
  }
  public List<Product> findAll(){
	  return template.opsForHash().values(HASH_VALUE);
  }
  public Product findProductById(int id) {
      return (Product) template.opsForHash().get(HASH_VALUE,id);
  }
  public String deleteProduct(int id) {
	  template.opsForHash().delete(HASH_VALUE, id);
	  return "product removed !!";
  }
}
