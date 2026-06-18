package com.Eshop.product_service.Domain.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Eshop.product_service.Domain.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
