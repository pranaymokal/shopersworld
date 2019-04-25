package com.shoperworld.core.services;

import java.util.List;

import com.shoperworld.core.models.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
	
	Product saveProduct(Product product);
	
	void deleteProductById(Long productId);
}
