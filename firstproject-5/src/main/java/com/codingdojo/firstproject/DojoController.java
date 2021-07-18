package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("{v}")
	public String index(@PathVariable("v")String x) {
		
		if(x.equals("dojo")) {
		return "The dojo is awesome!";
	}	
		else if(x.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		
		return "please enter a valid url";
	}
	

}
