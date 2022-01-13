package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ClaseVO;

public interface ClaseService {

	<S extends ClaseVO> S save(S entity);

	<S extends ClaseVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ClaseVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ClaseVO> findAll();

	Iterable<ClaseVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ClaseVO entity);

	void deleteAll(Iterable<? extends ClaseVO> entities);

	void deleteAll();

}