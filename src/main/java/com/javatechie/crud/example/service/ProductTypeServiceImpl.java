package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.ProductType;
import com.javatechie.crud.example.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{

	@Override
	public ProductType save(ProductType entity) {
		return productTypeRepository.save(entity);
	}

	@Override
	public Optional<ProductType> findOne(Example<ProductType> example) {
		return productTypeRepository.findOne(example);
	}

	@Override
	public Page<ProductType> findAll(Pageable pageable) {
		return productTypeRepository.findAll(pageable);
	}

	@Override
	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	@Override
	public List<ProductType> findAll(Sort sort) {
		return productTypeRepository.findAll(sort);
	}

	@Override
	public List<ProductType> findAllById(Iterable<Integer> ids) {
		return productTypeRepository.findAllById(ids);
	}

	@Override
	public <S extends ProductType> List<S> saveAll(Iterable<S> entities) {
		return productTypeRepository.saveAll(entities);
	}

	@Override
	public ProductType findById(Integer id) {
		return productTypeRepository.findById(id).orElse(null);
	}

	@Override
	public void flush() {
		productTypeRepository.flush();
	}

	@Override
	public <S extends ProductType> S saveAndFlush(S entity) {
		return productTypeRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return productTypeRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<ProductType> entities) {
		productTypeRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ProductType> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productTypeRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		productTypeRepository.deleteAllInBatch();
	}

	@Override
	public ProductType getOne(Integer id) {
		return productTypeRepository.getOne(id);
	}

	@Override
	public <S extends ProductType> long count(Example<S> example) {
		return productTypeRepository.count(example);
	}

	@Override
	public <S extends ProductType> boolean exists(Example<S> example) {
		return productTypeRepository.exists(example);
	}

	@Override
	public <S extends ProductType> List<S> findAll(Example<S> example) {
		return productTypeRepository.findAll(example);
	}

	@Override
	public long count() {
		return productTypeRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		productTypeRepository.deleteById(id);
	}

	@Override
	public <S extends ProductType> List<S> findAll(Example<S> example, Sort sort) {
		return productTypeRepository.findAll(example, sort);
	}

	@Override
	public void delete(ProductType entity) {
		productTypeRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ProductType> entities) {
		productTypeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productTypeRepository.deleteAll();
	}

	@Autowired
    private ProductTypeRepository productTypeRepository;
}
