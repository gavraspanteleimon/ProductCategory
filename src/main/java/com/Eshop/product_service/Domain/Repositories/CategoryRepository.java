package com.Eshop.product_service.Domain.Repositories;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
