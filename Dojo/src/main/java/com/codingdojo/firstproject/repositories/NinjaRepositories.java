package com.codingdojo.firstproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.firstproject.models.Ninja;

public interface NinjaRepositories extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}