package com.javatechie.crud.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Bills;

@Repository
public interface BillsRepository extends CrudRepository<Bills, Integer>{

	
}
