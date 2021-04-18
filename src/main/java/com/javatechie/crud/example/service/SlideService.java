package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Slide;

@Service
public interface SlideService{

	void deleteAll();

	void deleteAll(Iterable<? extends Slide> entities);

	void delete(Slide entity);

	<S extends Slide> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Integer id);

	long count();

	<S extends Slide> List<S> findAll(Example<S> example);

	<S extends Slide> boolean exists(Example<S> example);

	<S extends Slide> long count(Example<S> example);

	Slide getOne(Integer id);

	void deleteAllInBatch();

	<S extends Slide> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Slide> entities);

	boolean existsById(Integer id);

	<S extends Slide> S saveAndFlush(S entity);

	void flush();

	Optional<Slide> findById(Integer id);

	List<Slide> saveAll(List<Slide> entities);

	List<Slide> findAllById(Iterable<Integer> ids);

	List<Slide> findAll(Sort sort);

	List<Slide> findAll();

	Page<Slide> findAll(Pageable pageable);

	<S extends Slide> Optional<S> findOne(Example<S> example);

	Slide save(Slide entity);

}
