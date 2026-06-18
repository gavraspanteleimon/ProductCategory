package com.Eshop.product_service.DataAccessLayer.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Eshop.product_service.DataAccessLayer.Dtos.CategoryDto;
import com.Eshop.product_service.Domain.Entities.Category;
import com.Eshop.product_service.Domain.Repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CategoryService {
	
	public CategoryRepository categoryRepository ;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<CategoryDto> getAllCategories() {
		return categoryRepository.findAll().stream()
				.map( c -> {
					CategoryDto dto = new CategoryDto() ;
					dto.setId(c.getId());
					dto.setName(c.getName());
					dto.setDescription(c.getDescription());
					return dto ;
				})
		.collect(Collectors.toList());
	}
	
	public CategoryDto getCategoryById(int id) {
		Category c = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("The category with id: "+ id + "is not found"));
		CategoryDto dto = new CategoryDto() ;
		dto.setId(c.getId());
		dto.setName(c.getName());
		dto.setDescription(c.getDescription());
		return dto ;	
	}
		
	@Transactional
	public int createCategory(@Valid CategoryDto c) {
		Category entity = new Category();
		entity.setName(c.getName());
		Category saved = categoryRepository.save(entity);
		return saved.getId();
	}
	
	@Transactional
	public CategoryDto updateCategory(@Valid CategoryDto c) {
		Category entity = categoryRepository.findById(c.getId())
				.orElseThrow(() -> new RuntimeException("The category with id: "+ c.getId() + "is not found"));
			entity.setName(c.getName());
			categoryRepository.save(entity);
			return c;
	}
	@Transactional
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
}
