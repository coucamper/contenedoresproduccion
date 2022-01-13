package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.EmpleadoVO;

public interface EmpleadoService {

	<S extends EmpleadoVO> S save(S entity);

	<S extends EmpleadoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<EmpleadoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<EmpleadoVO> findAll();

	Iterable<EmpleadoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(EmpleadoVO entity);

	void deleteAll(Iterable<? extends EmpleadoVO> entities);

	void deleteAll();

}