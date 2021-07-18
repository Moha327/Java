package com.codingdojo.firstproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.firstproject.models.Idea;
import com.codingdojo.firstproject.models.User;
import com.codingdojo.firstproject.services.IdeaService;
import com.codingdojo.firstproject.services.UserService;

@Controller
public class IdeaController {
	
	private final IdeaService ideaService;
	private final UserService userService;
	
	public IdeaController(IdeaService ideaService, UserService userService) {
		this.ideaService=ideaService;
		this.userService=userService;
	}
	

	@GetMapping("/ideas")
	public String index(HttpSession session, Model model) {
    	Long u_id=(Long) session.getAttribute("u_id");
    	User u=userService.findUserById(u_id);
    	model.addAttribute("user", u);
    	List<Idea> allIdeas=ideaService.findAll();
    	model.addAttribute("allIdeas", allIdeas);
		return "index.jsp";
	}
	

	@GetMapping("/ideas/new")
	public String createPage(@Valid @ModelAttribute("newidea") Idea newidea) {
		return "create.jsp";
	}

	@PostMapping("/ideas/new")
	public String create(@Valid @ModelAttribute("newidea") Idea newidea, BindingResult result, HttpSession session) {
    	Long u_id=(Long) session.getAttribute("u_id");
    	User u=userService.findUserById(u_id);
    	if(result.hasErrors()) {
    		return "create.jsp";
    	}else {
    		newidea.setCreator(u);
    		ideaService.createIdea(newidea);
    		return "redirect:/ideas";
    	}    	
		
	}
	
	@GetMapping("/ideas/{id}")
	public String info(@PathVariable("id")Long id, Model model) {
		Idea idea=ideaService.findIdeaById(id);
		model.addAttribute("idea", idea);
		return "info.jsp";
	}
	
	@GetMapping("/ideas/{id}/edit")
	public String editPage(@PathVariable("id")Long id, @Valid @ModelAttribute("updatedidea") Idea updatedidea, HttpSession session, Model model) {
		Idea idea=ideaService.findIdeaById(id);
		model.addAttribute("idea", idea);
    	Long u_id=(Long) session.getAttribute("u_id");
		if(idea.getCreator().getId().equals(u_id)) {
			return "edit.jsp";
		}else {
			return "redirect:/ideas";
		}
		
	}

	@PostMapping("/ideas/{id}/edit")
	public String edit(@PathVariable("id")Long id, @Valid @ModelAttribute("updatedidea") Idea updatedidea,BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "redirect:/ideas/"+id+"/edit";
		}else {
	    	Long u_id=(Long) session.getAttribute("u_id");
	    	User u=userService.findUserById(u_id);
	    	updatedidea.setCreator(u);
	    	ideaService.updateIdea(updatedidea);
	    	return "redirect:/ideas";
		}
	}

	@PostMapping("/ideas/{id}")
	public String destroy(@PathVariable("id")Long id) {
		ideaService.deleteIdea(id);
		return "redirect:/ideas";
	}

	@GetMapping("/ideas/{id}/like")
	public String like(@PathVariable("id")Long id, HttpSession session) {
		Idea idea=ideaService.findIdeaById(id);
    	Long u_id=(Long) session.getAttribute("u_id");
    	User u=userService.findUserById(u_id);
    	List<User> likedIdeas=idea.getLikedUser();
    	likedIdeas.add(u);
    	idea.setLikedUser(likedIdeas);
    	ideaService.updateIdea(idea);
		return "redirect:/ideas";
	}
	
	@GetMapping("/ideas/{id}/unlike")
	public String unlike(@PathVariable("id")Long id, HttpSession session) {
		Idea idea=ideaService.findIdeaById(id);
    	Long u_id=(Long) session.getAttribute("u_id");
    	User u=userService.findUserById(u_id);
    	List<User> likedIdeas=idea.getLikedUser();
    	likedIdeas.remove(u);
    	idea.setLikedUser(likedIdeas);
    	ideaService.updateIdea(idea);
		return "redirect:/ideas";
	}		
}