package com.codingdojo.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.firstproject.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
}