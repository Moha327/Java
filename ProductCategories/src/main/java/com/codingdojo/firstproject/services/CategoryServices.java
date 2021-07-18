package com.codingdojo.firstproject.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;
import com.codingdojo.firstproject.repositories.CategoryRepositories;
import com.codingdojo.firstproject.repositories.ProductsRepositories;

public class CategoryServices {

	private final ProductsRepositories productsRepositories;
	private final CategoryRepositories categoryRepositories;

	
	
	public CategoryServices(ProductsRepositories productsRepositories, CategoryRepositories categoryRepository) {
		
		this.productsRepositories = productsRepositories;
		this.categoryRepositories = categoryRepository;
	
	}
	public Category  createCategory(Category category ) {
		return categoryRepositories.save(category);	
	}
	
	public List<Category> findAllCategory(){
		return categoryRepositories.findAll();
	}
	public Category findCategory(Long id){
		  Optional<Category> optionalCategory = categoryRepositories.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }

	}
	public List<Category>  CategoryWithoutProudct() {
		return categoryRepositories.findByProductsIsNull();	
	}
	public List<Category> CategoryWithoutProudct(Product p){
		return  categoryRepositories.findByProductsNotContains(p);
	}
	public void updatecategory(Long idp,Long idc ) {
	
		Product product2=ProductServices.findProduct(idp);
		Category cat =this.findCategory(idc);
		List <Product> p=cat.getProducts();
		p.add(product2);
		cat.setProducts(p);
		categoryRepositories.save(cat);
	}
}
