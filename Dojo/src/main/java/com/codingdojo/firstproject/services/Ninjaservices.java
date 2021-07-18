package com.codingdojo.firstproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.firstproject.models.Ninja;
import com.codingdojo.firstproject.repositories.NinjaRepositories;

@Service
public class Ninjaservices {
	private final NinjaRepositories ninjaRepositories;

	public Ninjaservices(NinjaRepositories ninjaRepositories) {
		super();
		this.ninjaRepositories = ninjaRepositories;
	}

	public Ninja  createNinja(Ninja ninja ) {
		return ninjaRepositories.save(ninja);	
	}
	
	public List<Ninja> findAlNinja(){
		return ninjaRepositories.findAll();
	}
	public Ninja findNinja(Long id){
		  Optional<Ninja> optionalNinja = ninjaRepositories.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }

	}

}