package com.Eshop.product_service.DataAccessLayer.Services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Eshop.product_service.DataAccessLayer.Dtos.ProductDto;
import com.Eshop.product_service.Domain.Entities.Product;
import com.Eshop.product_service.Domain.Repositories.CategoryRepository;
import com.Eshop.product_service.Domain.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ProductService {



	public ProductRepository productRepository ;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository ;

	}
	
	public List<ProductDto> getAllnames() {
		
		return productRepository.findAll().stream()
				.map( c -> {
				ProductDto dto = new ProductDto() ;
				dto.setName(c.getName());
				dto.setId(c.getId());
				dto.setPrice(c.getPrice());
				dto.setStock(c.getStock());
				return dto ;
		
				})
				.collect(Collectors.toList());
					
	}
	public ProductDto getProductById(int id) {
		Product	c = productRepository.findById(id)
					.orElseThrow( () -> new RuntimeException("The product with the id : "+ id +"is not found"));
		ProductDto dto = new ProductDto() ;
		dto.setName(c.getName());
		dto.setId(c.getId());
		dto.setPrice(c.getPrice());
		dto.setStock(c.getStock());
		return dto ;

	}
	
	@Transactional
	public int createProdut(@Valid ProductDto dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		Product saved = productRepository.save(entity);
		return saved.getId();
	
	}
	@Transactional
	public ProductDto updateProduct(@Valid ProductDto c)
	{
		Product entity = productRepository.findById(c.getId())
				.orElseThrow (() -> new RuntimeException("The product with the id : "+ c.getId() +"is not found"));
		entity.setName(c.getName());
		productRepository.save(entity);
		return c;
				
	}
	@Transactional 
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	
}
