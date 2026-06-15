package com.Eshop.product_service.Domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity ( name = "product")
public class Product {
	
	@Id
	@Column
	@GeneratedValue
	protected int id ;
	
	@Column
	protected String name ;
	
	@Column
	protected double price ;
	
	@Column
	protected int stock ;
	
	@ManyToOne
	@JoinColumn(name = "Category_id")
	private Category category ;
	
	public Product () {}

	public Product(int id, String name, double price, int stock) {
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
