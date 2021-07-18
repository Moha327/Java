package com.codingdojo.firstproject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.firstproject.models.Dojo;
import com.codingdojo.firstproject.models.Ninja;
import com.codingdojo.firstproject.services.Dojoservices;
import com.codingdojo.firstproject.services.Ninjaservices;

@Controller
public class NinjaController {
	private final Ninjaservices ninjaservices;
	private final Dojoservices dojoservices;


	
	
	


	public NinjaController(Ninjaservices ninjaservices, Dojoservices dojoservices) {
		super();
		this.ninjaservices = ninjaservices;
		this.dojoservices = dojoservices;
	}

	@RequestMapping("/Ninja/new")
	public String NinjaNew(Model model) {
		List<Dojo> dojo =dojoservices.findAllDojo();
		

	    model.addAttribute("dojos", dojo );
	    model.addAttribute("ninja", new Ninja());
	    return "ninja.jsp";
	}

	@RequestMapping(value="/Ninja/new",method=RequestMethod.POST)
	public String index2(@ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
		if (result.hasErrors()) {
	        return "ninja.jsp";
	    } 
		
		ninjaservices.createNinja(ninja);
		
		
	    return "redirect:/Ninja/new";
	}
}