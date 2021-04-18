package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Departs;

@Service
public interface DepartsService{

	void deleteAll();

	void deleteAll(List<Departs> entities);

	void delete(Departs entity);

	void deleteById(Integer id);

	long count();

	List<Departs> findAllById(List<Integer> ids);

	List<Departs> findAll();

	boolean existsById(Integer id);

	Departs findById(Integer id);

	List<Departs> saveAll(List<Departs> entities);

	Departs save(Departs entity);

	
}
