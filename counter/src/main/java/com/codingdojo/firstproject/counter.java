package com.codingdojo.firstproject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class counter {
	public static int myCounter=0;
	
	@RequestMapping("/your_server")
	public String index(Model model, HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("count", 0);

		}
		
		myCounter++;
			
		return "index.jsp";
	}
	@RequestMapping("/your_server/counter")
	public String e(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("count", 0);

		}
			
			
			session.setAttribute("count", myCounter);
			return "counter.jsp";
			}
		
	}
