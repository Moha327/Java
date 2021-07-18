package com.codingdojo.firstproject;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mohammed {
	@RequestMapping("")
	public String index() {
        return "Hello Human !";
       
    }
	
	 
}