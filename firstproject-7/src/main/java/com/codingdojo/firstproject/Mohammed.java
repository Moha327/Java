package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mohammed {
	@RequestMapping("")
	public String mohammed() {
		     return "Hello Human!";
		
	}
	
	
	@RequestMapping("{name}")
	public String mohammed(@PathVariable("name") String Name) {
		     return "Hello "+Name+"!";
		
	}
}
