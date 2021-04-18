package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.ProductType;
import com.javatechie.crud.example.entity.Products;

@Service
public interface ProductsService {

	void deleteAll();

	void deleteAll(Iterable<? extends Products> entities);

	void delete(Products entity);

	<S extends Products> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Integer id);

	long count();

	<S extends Products> List<S> findAll(Example<S> example);

	<S extends Products> boolean exists(Example<S> example);

	<S extends Products> long count(Example<S> example);

	Products getOne(Integer id);

	void deleteAllInBatch();

	<S extends Products> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Products> entities);

	boolean existsById(Integer id);

	<S extends Products> S saveAndFlush(S entity);

	void flush();

	Products findById(Integer id);

	<S extends Products> List<S> saveAll(Iterable<S> entities);

	List<Products> findAllById(Iterable<Integer> ids);

	List<Products> findAll(Sort sort);

	List<Products> findAll();

	Page<Products> findAll(Pageable pageable);

	<S extends Products> Optional<S> findOne(Example<S> example);

	Products save(Products entity);

	List<Products> findByProductType(Integer idType);

	List<Products> getListNewProduct();
}
