package com.codingdojo.firstproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.firstproject.models.Dojo;

public interface DojoRepositories  extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();

}