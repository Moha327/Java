package com.codingdojo.firstproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.firstproject.models.Lookify;
public interface Lookifyrepositories extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	 List<Lookify> findByArtist(String search);
}