package com.shoperworld.core.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "products", schema = "product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = -1156543556846251216L;
	
    @ApiModelProperty(notes = "The database generated product ID")
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ApiModelProperty(notes = "The application-specific product ID")
	private Long productId;
	
    @ApiModelProperty(notes = "The name of product")
	private String productName;
	
    @ApiModelProperty(notes = "The product description")
	private String productDescription;
	
    @ApiModelProperty(notes = "The price of the product", required = true)
    private BigDecimal productPrice;
	
    @ApiModelProperty(notes = "The product category")
	private String productCategory;

    @ApiModelProperty(notes = "The image URL of the product")
    private String productImageUrl;

	public Product() {
		super();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
}
