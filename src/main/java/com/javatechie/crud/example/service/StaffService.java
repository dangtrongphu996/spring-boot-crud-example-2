package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Staffs;

@Service
public interface StaffService{

	void deleteAll();

	void deleteAll(List<Staffs> entities);

	void delete(Staffs entity);

	void deleteById(Integer id);

	long count();

	List<Staffs> findAllById(List<Integer> ids);

	List<Staffs> findAll();

	boolean existsById(Integer id);

	Staffs findById(Integer id);

	List<Staffs> saveAll(List<Staffs> entities);

	Staffs save(Staffs entity);

	
}
