package com.javatechie.crud.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.crud.example.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	  
	@Query("SELECT e FROM customer e")
	Page<Customer> findCustomers(Pageable pageable);
	
	@Query("SELECT count(*) FROM customer e")
	long findCustomers();
	
	@Query("SELECT e FROM customer e WHERE e.name LIKE %?1% or e.address LIKE %?1% or e.city LIKE %?1% or e.pincode LIKE %?1% or e.country LIKE %?1%")
	Page<Customer> findByName(Pageable pageable,String keyword);
	
	@Query("SELECT e FROM customer e WHERE e.name LIKE %?1% or e.address LIKE %?1% or e.city LIKE %?1% or e.pincode LIKE %?1% or e.country LIKE %?1%")
	List<Customer> findByName(String keyword);
}