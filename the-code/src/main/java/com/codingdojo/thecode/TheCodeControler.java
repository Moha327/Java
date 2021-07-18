package com.codingdojo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class TheCodeControler {
	 @RequestMapping(value="/codex", method=RequestMethod.POST)
    public String login(@RequestParam(value="code") String code) {
          if(code.equals("bushido")) {
       	   return "redirect:/code";
          }
          else
          return "redirect:/createError";
    }
	 @RequestMapping("/code")
	    public String index3() {
	    	
	        return "secret.jsp";}
	 
	 @RequestMapping("/")
	    public String index2() {
	    	
	        return "index.jsp";
	        }
	 @RequestMapping("/createError")
	    public String flashMessages(RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("error", "Something Rong");
	        return "redirect:/";
	        }
}