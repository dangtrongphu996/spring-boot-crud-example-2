package com.javatechie.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
	@Query("SELECT p FROM product_tbl p WHERE p.name LIKE %?1%")
	public List<Product> findByName(String keyword);
}