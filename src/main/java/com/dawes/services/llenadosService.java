package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.llenadosRutaVO;

public interface llenadosService {

	<S extends llenadosRutaVO> S save(S entity);

	<S extends llenadosRutaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<llenadosRutaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<llenadosRutaVO> findAll();

	Iterable<llenadosRutaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(llenadosRutaVO entity);

	void deleteAll(Iterable<? extends llenadosRutaVO> entities);

	void deleteAll();

}