package com.Eshop.product_service.DataAccessLayer.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
	
	private int id ;
	
	@NotNull( message = " name can not be null")
	@NotEmpty( message = " name can not be empty")
	private String name ;
	
	private double price ;
	
	private int stock ;
	
	public ProductDto() {}

	public ProductDto(int id,
			@NotNull(message = " name can not be null") @NotEmpty(message = " name can not be empty") String name,
			double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	

}
