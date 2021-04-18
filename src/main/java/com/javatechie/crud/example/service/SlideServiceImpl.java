package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Slide;
import com.javatechie.crud.example.repository.SlideRepository;

@Service
public class SlideServiceImpl implements SlideService{
	

	@Autowired
    private SlideRepository slideRepository;
	
	@Override
	public Slide save(Slide entity) {
		return slideRepository.save(entity);
	}

	@Override
	public <S extends Slide> Optional<S> findOne(Example<S> example) {
		return slideRepository.findOne(example);
	}

	@Override
	public Page<Slide> findAll(Pageable pageable) {
		return slideRepository.findAll(pageable);
	}

	@Override
	public List<Slide> findAll() {
		return slideRepository.findAll();
	}

	@Override
	public List<Slide> findAll(Sort sort) {
		return slideRepository.findAll(sort);
	}

	@Override
	public List<Slide> findAllById(Iterable<Integer> ids) {
		return slideRepository.findAllById(ids);
	}

	@Override
	public List<Slide> saveAll(List<Slide> entities) {
		return slideRepository.saveAll(entities);
	}

	@Override
	public Optional<Slide> findById(Integer id) {
		return slideRepository.findById(id);
	}

	@Override
	public void flush() {
		slideRepository.flush();
	}

	@Override
	public <S extends Slide> S saveAndFlush(S entity) {
		return slideRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return slideRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Slide> entities) {
		slideRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Slide> Page<S> findAll(Example<S> example, Pageable pageable) {
		return slideRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		slideRepository.deleteAllInBatch();
	}

	@Override
	public Slide getOne(Integer id) {
		return slideRepository.getOne(id);
	}

	@Override
	public <S extends Slide> long count(Example<S> example) {
		return slideRepository.count(example);
	}

	@Override
	public <S extends Slide> boolean exists(Example<S> example) {
		return slideRepository.exists(example);
	}

	@Override
	public <S extends Slide> List<S> findAll(Example<S> example) {
		return slideRepository.findAll(example);
	}

	@Override
	public long count() {
		return slideRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		slideRepository.deleteById(id);
	}

	@Override
	public <S extends Slide> List<S> findAll(Example<S> example, Sort sort) {
		return slideRepository.findAll(example, sort);
	}

	@Override
	public void delete(Slide entity) {
		slideRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Slide> entities) {
		slideRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		slideRepository.deleteAll();
	}
	
}
