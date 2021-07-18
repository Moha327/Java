package com.codingdojo.firstproject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;
import com.codingdojo.firstproject.services.CategoryServices;
import com.codingdojo.firstproject.services.ProductServices;

@Controller
public class CategoriesControllers {
	private final ProductServices proudctServices;
	private final CategoryServices categoryServices;

	public class CategoriesControllers(ProductServices productServices, CategoryServices categoryServices) {
		super();
		this.productServices = productServices;
		this.categoryServices = categoryServices;
	}
	
	
	@RequestMapping("/category/new")
	public String index(Model model) {
	    model.addAttribute("category", new Category() );
	    return "newcatg.jsp";
	}
	@RequestMapping(value="/category/new",method=RequestMethod.POST)
	public String index2(@ModelAttribute("person") Category category, BindingResult result,Model model) {
		if (result.hasErrors()) {
	        return "newcatg.jsp";
	    } 
		categoryServices.createCategory(category);
		
	    return "redirect:/category/new";
	}
	@RequestMapping("/category/{Id}")
	public String show(@PathVariable("Id") Long id1,Model model) {
		Category category =categoryServices.findCategory(id1);
		
	
	  List<Product> product=productServices.ProductsWithoutCategories(category);
	  model.addAttribute("category",category);
	  model.addAttribute("product",product);
	 

	        return "show2.jsp";
	    }
	
	@RequestMapping(value="/category/update",method=RequestMethod.POST)
	public String index3(@RequestParam(value="product") Long idp, @RequestParam(value="id") Long id,Model model) {
		
		categoryServices.updatecategory(idp,id);
		
	    return "redirect:/category/"+id;
	}
}

