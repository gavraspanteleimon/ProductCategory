package com.Eshop.product_service.DataAccessLayer.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategoryDto {
	
	private int id ;
	
	@NotNull( message = " name can not be null")
	@NotEmpty( message = " name can not be empty")
	private String name ;
	
	private String description;
	
	public CategoryDto() {} 

	public CategoryDto(int id,
			@NotNull(message = " name can not be null") @NotEmpty(message = " name can not be empty") String name,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
