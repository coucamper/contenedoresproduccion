package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.ConcejoVO;

public interface ConcejoService {

	<S extends ConcejoVO> S save(S entity);

	<S extends ConcejoVO> Optional<S> findOne(Example<S> example);

	Page<ConcejoVO> findAll(Pageable pageable);

	List<ConcejoVO> findAll();

	List<ConcejoVO> findAll(Sort sort);

	List<ConcejoVO> findAllById(Iterable<Integer> ids);

	<S extends ConcejoVO> List<S> saveAll(Iterable<S> entities);

	Optional<ConcejoVO> findById(Integer id);

	void flush();

	<S extends ConcejoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<ConcejoVO> entities);

	<S extends ConcejoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	ConcejoVO getOne(Integer id);

	<S extends ConcejoVO> long count(Example<S> example);

	<S extends ConcejoVO> boolean exists(Example<S> example);

	<S extends ConcejoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends ConcejoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(ConcejoVO entity);

	void deleteAll(Iterable<? extends ConcejoVO> entities);

	void deleteAll();

}