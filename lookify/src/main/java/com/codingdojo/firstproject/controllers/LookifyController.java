package com.codingdojo.firstproject.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.firstproject.models.Lookify;

import com.codingdojo.firstproject.services.Lookifyservice;
public class LookifyController {
	private final  Lookifyservice lookifyservice;
	public LookifyController(Lookifyservice lookifyservice) {
		this.lookifyservice = lookifyservice;
	}
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	@RequestMapping("/dashboard")
    public String start(Model model) {
		List<Lookify> lookify=lookifyservice.allLookify();
		model.addAttribute("songs",lookify);
		model.addAttribute("song",new Lookify());
        return "dashborad.jsp";
    }
	@RequestMapping("/songs/new")
    public String newsong(Model model) {
		model.addAttribute("song",new Lookify());
        return "new.jsp";
    }
	 @RequestMapping("/songs/{Id}")
	    public String show(@PathVariable("Id") Long id1,Model model) {
		  
		 Lookify lookify=lookifyservice.findLookify(id1);
		  
		  model.addAttribute("song",lookify);
	
	            return "show.jsp";
	        }
	 public String destroy(@PathVariable("id") Long id) {
	    	lookifyservice.deleteLookify(id);
	        return "redirect:/dashboard";
	    }
}
