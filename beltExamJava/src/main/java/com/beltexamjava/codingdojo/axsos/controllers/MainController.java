package com.beltexamjava.codingdojo.axsos.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beltexamjava.codingdojo.axsos.models.Course;
import com.beltexamjava.codingdojo.axsos.models.User;
import com.beltexamjava.codingdojo.axsos.services.CourseService;
import com.beltexamjava.codingdojo.axsos.services.UserService;
import com.beltexamjava.codingdojo.axsos.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final CourseService courseService;

	public MainController(UserService userService, UserValidator userValidator, CourseService courseService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.courseService = courseService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/courses";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/courses";
		} else {
			model.addAttribute("user", new User());
			model.addAttribute("error", "Invalid Email/Password. Please try again.");
			return "index.jsp";
		}
	}

	@RequestMapping("/courses")
	public String homepage(HttpSession session, Model model) {

		if (session.getAttribute("userId") != null) {
			// get user from session, save them in the model and return the home page
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);

			// model pass u user to jsp in order to display current user login name
			model.addAttribute("user", u);

			// render cours in table

			List<Course> courseList = courseService.findAllCourses();
			model.addAttribute("courses", courseList);
			return "homePage.jsp";

		} else {
			System.out.println("You have not logged in");
			return "redirect:/";
		}
	}

	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/courses/new")
	public String courseCreation(@ModelAttribute("course") Course myCourse) {
		return "show.jsp";
	}

	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("course") Course myCourse, BindingResult result) {
		if (result.hasErrors()) {

			System.out.println("Error while creating course");
			return "show.jsp";
		} else {
			System.out.println("------- Create course ------");
			courseService.createCourse(myCourse);
			return "redirect:/courses";
		}
	}

	@RequestMapping("courses/{id}")
	public String displayCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Course myCourse = courseService.findCourseById(myId);
		model.addAttribute("course", myCourse);

		List<User> users = myCourse.getUsers();
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("currentUser",u);
		System.out.println("--get id-- "+u.getId());
		return "showinfo.jsp";
	}

	@RequestMapping("/courses/add/{id}")
	public String addCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Course course = courseService.findCourseById(myId);
		
		u.getCourses().add(course);
		userService.updateUser(u);
		
		
		return "redirect:/courses";
	}

	
	@RequestMapping("/courses/{id}/edit")
	public String editPage(@ModelAttribute("course") Course myCourse, @PathVariable("id") Long myId, Model model) {
		Course course = courseService.findCourseById(myId);
		model.addAttribute("course", course);
		return "edit.jsp";
	}

	@PostMapping("/courses/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course myCourse, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			List<User> myStudents =myCourse.getUsers();
			System.out.println("--- all students --- "+ myStudents);
			courseService.updateCourse(myCourse);
			
			return "redirect:/courses";
		}
	}

	@RequestMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		Course myCourse = courseService.findCourseById(id);
		if (myCourse != null) {
			courseService.deleteCourse(myCourse);
			return "redirect:/courses";
		} else {
			System.out.println("Course doesn't exist");
			return "redirect:/courses";
		}

	}

	@RequestMapping("/courses/{id}/remove")
	public String removeUserFromCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Course course = courseService.findCourseById(myId);
		
		u.getCourses().remove(course);
		userService.updateUser(u);
		
		return "redirect:/courses";
	}
	
	@RequestMapping("/courses/{id}/add")
		public String addUserToCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			Course course = courseService.findCourseById(myId);
			
			u.getCourses().add(course);
			userService.updateUser(u);
			
			return "redirect:/courses";
		}
	

}
