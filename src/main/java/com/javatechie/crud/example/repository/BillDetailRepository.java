package com.javatechie.crud.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.BillDetail;

@Repository
public interface BillDetailRepository extends CrudRepository<BillDetail, Integer>{

	
}
