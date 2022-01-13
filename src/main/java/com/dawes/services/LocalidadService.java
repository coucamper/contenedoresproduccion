package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.LocalidadVO;

public interface LocalidadService {

	<S extends LocalidadVO> S save(S entity);

	<S extends LocalidadVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<LocalidadVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<LocalidadVO> findAll();

	Iterable<LocalidadVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(LocalidadVO entity);

	void deleteAll(Iterable<? extends LocalidadVO> entities);

	void deleteAll();

}