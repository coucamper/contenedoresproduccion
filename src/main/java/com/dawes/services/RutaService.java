package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.RutaVO;

public interface RutaService {

	<S extends RutaVO> S save(S entity);

	<S extends RutaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RutaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RutaVO> findAll();

	Iterable<RutaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RutaVO entity);

	void deleteAll(Iterable<? extends RutaVO> entities);

	void deleteAll();

}