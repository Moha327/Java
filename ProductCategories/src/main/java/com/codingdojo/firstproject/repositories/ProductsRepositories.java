package com.codingdojo.firstproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;

public interface ProductsRepositories extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesIsNull();
	
	List<Product> findByCategoriesNotContaining(Category c);

}
