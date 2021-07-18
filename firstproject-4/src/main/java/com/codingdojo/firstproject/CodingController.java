package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	public static void main(String[] args) {
		SpringApplication.run(Firstproject4Application.class, args);
	}
	 @RequestMapping("/coding")
    public String hi() {
		 
    	return "Hello Coding Dojo";
    }
	 @RequestMapping("/coding/python")
	    public String hi1() {
			 
	    	return "'Python/Django was awesome!";
	    }
	 @RequestMapping("/coding/java")
	    public String hi2() {
			 
	    	return "Java/Spring is better!";
	    }
}
