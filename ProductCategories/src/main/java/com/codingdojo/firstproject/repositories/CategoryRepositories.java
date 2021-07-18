package com.codingdojo.firstproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;

public interface CategoryRepositories extends CrudRepository<Category, Long> {
List<Category> findAll();
List<Category> findByProductsIsNull();

List<Category> findByProductsNotContains(Product pro);
Category findByName(String Name);





}