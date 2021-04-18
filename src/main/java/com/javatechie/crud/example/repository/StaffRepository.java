package com.javatechie.crud.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Staffs;

@Repository
public interface StaffRepository extends CrudRepository<Staffs, Integer>{

	
}
