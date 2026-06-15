package com.Eshop.product_service.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eshop.product_service.Domain.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
