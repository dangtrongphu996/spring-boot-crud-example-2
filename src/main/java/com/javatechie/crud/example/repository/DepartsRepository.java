package com.javatechie.crud.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Departs;

@Repository
public interface DepartsRepository extends CrudRepository<Departs, Integer>{

	
}
