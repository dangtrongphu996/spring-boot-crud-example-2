package com.javatechie.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    
	@Query("SELECT p FROM products p WHERE p.productType.id = ?1")
	List<Products> findByProductType(Integer idType);
}