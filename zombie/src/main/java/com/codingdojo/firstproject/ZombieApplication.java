package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class ZombieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZombieApplication.class, args);
	}
   
}
