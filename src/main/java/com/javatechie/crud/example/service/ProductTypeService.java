package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.ProductType;

@Service
public interface ProductTypeService {

	void deleteAll();

	void deleteAll(Iterable<? extends ProductType> entities);

	void delete(ProductType entity);

	<S extends ProductType> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Integer id);

	long count();

	<S extends ProductType> List<S> findAll(Example<S> example);

	<S extends ProductType> boolean exists(Example<S> example);

	<S extends ProductType> long count(Example<S> example);

	ProductType getOne(Integer id);

	void deleteAllInBatch();

	<S extends ProductType> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<ProductType> entities);

	boolean existsById(Integer id);

	<S extends ProductType> S saveAndFlush(S entity);

	void flush();

	ProductType findById(Integer id);

	<S extends ProductType> List<S> saveAll(Iterable<S> entities);

	List<ProductType> findAllById(Iterable<Integer> ids);

	List<ProductType> findAll(Sort sort);

	List<ProductType> findAll();

	Page<ProductType> findAll(Pageable pageable);

	Optional<ProductType> findOne(Example<ProductType> example);

	ProductType save(ProductType entity);
}
