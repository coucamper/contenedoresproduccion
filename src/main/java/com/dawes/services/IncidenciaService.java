package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.IncidenciaVO;

public interface IncidenciaService {

	<S extends IncidenciaVO> S save(S entity);

	<S extends IncidenciaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<IncidenciaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<IncidenciaVO> findAll();

	Iterable<IncidenciaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(IncidenciaVO entity);

	void deleteAll(Iterable<? extends IncidenciaVO> entities);

	void deleteAll();

}