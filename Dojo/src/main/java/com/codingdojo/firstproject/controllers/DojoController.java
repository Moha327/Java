package com.codingdojo.firstproject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.firstproject.models.Dojo;
import com.codingdojo.firstproject.models.Ninja;
import com.codingdojo.firstproject.services.Dojoservices;

@Controller
public class DojoController {
	private final Dojoservices dojoservices;

	public DojoController(Dojoservices dojoservices) {
		super();
		this.dojoservices = dojoservices;
	}
	@RequestMapping("/Dojo/new")
	public String index(Model model) {
	    model.addAttribute("dojo", new Dojo() );
	    return "dojo.jsp";
	}
	@RequestMapping(value="/Dojo/new",method=RequestMethod.POST)
	public String index2(@ModelAttribute("dojo") Dojo dojo, BindingResult result,Model model) {
		if (result.hasErrors()) {
	        return "dojo.jsp";
	    } 
		dojoservices.createDojo(dojo);
		
		
	    return "redirect:/Dojo/new";
	}
	@RequestMapping("/Dojo/{Id}")
	public String show(@PathVariable("Id") Long id1,Model model) {
	  Dojo dojo =dojoservices.findDojo(id1);
	  List<Ninja> ninja=dojo.getNinjas();
	  model.addAttribute("dojo",dojo);
	  model.addAttribute("ninjas",ninja);

	        return "show.jsp";
	    }

	
}