package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Departs;
import com.javatechie.crud.example.repository.DepartsRepository;

@Service
public class DepartsServiceImpl implements DepartsService{

	@Autowired
    private DepartsRepository repository;
	
	@Override
	public Departs save(Departs entity) {
		return repository.save(entity);
	}

	@Override
	public List<Departs> saveAll(List<Departs> entities) {
		return (List<Departs>)repository.saveAll(entities);
	}

	@Override
	public Departs findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public List<Departs> findAll() {
		return (List<Departs>)repository.findAll();
	}

	@Override
	public List<Departs> findAllById(List<Integer> ids) {
		return (List<Departs>)repository.findAllById(ids);
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
	public void delete(Departs entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAll(List<Departs> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
