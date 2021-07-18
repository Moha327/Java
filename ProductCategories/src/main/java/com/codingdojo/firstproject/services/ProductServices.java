package com.codingdojo.firstproject.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.firstproject.models.Category;
import com.codingdojo.firstproject.models.Product;
import com.codingdojo.firstproject.repositories.CategoryRepositories;
import com.codingdojo.firstproject.repositories.ProductsRepositories;

public class ProductServices {
	private final ProductsRepositories productRepository = null;
	private final CategoryRepositories categoryRepository = null;

	public void ProudctServices(ProductsRepositories productRepository, CategoryRepositories categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	
	public Product  createProduct(Product product ) {
		return productRepository.save(product);	
	}
	
	
	public List<Product> findAllProduct(){
		return productRepository.findAll();
	}
	
	
	public Product findProduct(Long id){
		  Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	            return optionalProduct.get();
	        } else {
	            return null;
	        }

	}
	public List<Product>  ProductWithoutCategory() {
		return productRepository.findByCategoriesIsNull();	
	}
	
	
	public void updateProduct(String name,Long id ) {
		Product product2=this.findProduct(id);
		Category cat =categoryRepository.findByName(name);
		List <Category> c=product2.getCategories();
		c.add(cat);
		product2.setCategories(c);
		productRepository.save(product2);
	}
	public List<Product> ProductWithoutcategory(Category c){
		return  productRepository.findByCategoriesNotContaining(c);
	}

}
