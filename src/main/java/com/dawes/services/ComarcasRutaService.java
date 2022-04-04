package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ComarcasRutaVO;

public interface ComarcasRutaService {

	<S extends ComarcasRutaVO> S save(S entity);

	<S extends ComarcasRutaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ComarcasRutaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ComarcasRutaVO> findAll();

	Iterable<ComarcasRutaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ComarcasRutaVO entity);

	void deleteAll(Iterable<? extends ComarcasRutaVO> entities);

	void deleteAll();

}