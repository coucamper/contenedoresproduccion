package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TurnoVO;

public interface TurnosService {

	<S extends TurnoVO> S save(S entity);

	<S extends TurnoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TurnoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TurnoVO> findAll();

	Iterable<TurnoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TurnoVO entity);

	void deleteAll(Iterable<? extends TurnoVO> entities);

	void deleteAll();

}