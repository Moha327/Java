package com.codingdojo.firstproject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DojoServey {
   @RequestMapping(value = "/result" , method = RequestMethod.POST)
   public String home(@ModelAttribute @RequestParam(value ="name") String name,@RequestParam(value ="location") String location,@RequestParam(value = "language") String language,@RequestParam(value = "comment") String comment, HttpSession session) {
   session.setAttribute("name1", name);
   session.setAttribute("location", location);
   session.setAttribute("language", language);
   session.setAttribute("comment", comment);
   return "redirect:/result";

   }
   @RequestMapping("/")
   public String index() {
	   return "index.jsp";
   }

	@RequestMapping("/result")
	public String result(Model model) {
		return "index1.jsp";
	}
}