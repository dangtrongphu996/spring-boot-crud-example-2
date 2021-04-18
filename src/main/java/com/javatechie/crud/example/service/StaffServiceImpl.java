package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Staffs;
import com.javatechie.crud.example.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
    private StaffRepository repository;
	
	@Override
	public Staffs save(Staffs entity) {
		return repository.save(entity);
	}

	@Override
	public List<Staffs> saveAll(List<Staffs> entities) {
		return (List<Staffs>)repository.saveAll(entities);
	}

	@Override
	public Staffs findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public List<Staffs> findAll() {
		return (List<Staffs>)repository.findAll();
	}

	@Override
	public List<Staffs> findAllById(List<Integer> ids) {
		return (List<Staffs>)repository.findAllById(ids);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Staffs entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staffs> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
