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

public class ProductsController {
	private final ProductServices productServices;
	private final CategoryServices categoryServices;

	

	public ProductsController(ProductServices productServices, CategoryServices categoryServices) {
		super();
		this.productServices = productServices;
		this.categoryServices = categoryServices;
	}
	@RequestMapping("/product/new")
	public String index(Model model) {
	    model.addAttribute("proudct", new Product() );
	    return "newproudct.jsp";
	}
	@RequestMapping(value="/product/new",method=RequestMethod.POST)
	public String index2(@ModelAttribute("product") Product product, BindingResult result,Model model) {
		if (result.hasErrors()) {
	        return "newproudct.jsp";
	    } 
		
		productServices.createProduct(product);
		
	    return "redirect:/product/new";
	}
	@RequestMapping("/product/{Id}")
	public String show(@PathVariable("Id") Long id1,Model model) {
		Product product =productServices.findProduct(id1);
		
	
	  List<Category> category=categoryServices.CategoryWithoutProudct(product);
	  model.addAttribute("product",product);
	  model.addAttribute("category",category);
	  model.addAttribute("pro",new Category());

	        return "show.jsp";
	    }
	
	@RequestMapping(value="/product/update",method=RequestMethod.POST)
	public String index3(@RequestParam(value="name") String name, @RequestParam(value="id") Long id,Model model) {
		
		productServices.updateProduct(name,id);
		
	    return "redirect:/product/"+ id;
	}
}
