package com.shoperworld.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoperworld.core.models.Product;
import com.shoperworld.core.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/products")
@Api(value="product")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

    @ApiOperation(value = "Get all products",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        })
	@RequestMapping(value = "/", method = RequestMethod.GET,produces="application/json")
	public List<Product> getAllProducts(Model model) {
		List<Product> productList=productService.getAllProducts();
		return productList;
	}

    @ApiOperation(value = "Add a product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Product save Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to add the product"),
			@ApiResponse(code = 400, message = "Bad request while adding product") })
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity addProduct(@ApiParam(value = "Product to add", required = true) @RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity("Product save successfully",HttpStatus.CREATED);
	}
	
    @ApiOperation(value = "View a product")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Product retrived Successfully"),
			@ApiResponse(code = 404, message = "Product not found") })
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces="application/json")
	public Product viewProduct(@PathVariable("id") Long productId) {
		Product product=productService.getProductById(productId);
		return product;
	}
	
    @ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes="application/json" , produces="application/json")
	public ResponseEntity updateProduct(@PathVariable("id") Long productId , @RequestBody Product product) {
		Product storedProduct=productService.getProductById(productId);
		storedProduct.setProductPrice(product.getProductPrice());
		storedProduct.setProductName(product.getProductName());
		storedProduct.setProductDescription(product.getProductDescription());
		storedProduct.setProductImageUrl(product.getProductImageUrl());
        return new ResponseEntity("Product updated successfully", HttpStatus.NO_CONTENT);
	}
	
    @ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes="application/json" , produces="application/json")
	public ResponseEntity deleteProduct(@PathVariable("id") Long productId) {
		productService.deleteProductById(productId);
        return new ResponseEntity("Product deleted successfully", HttpStatus.NO_CONTENT);
	}
    
}