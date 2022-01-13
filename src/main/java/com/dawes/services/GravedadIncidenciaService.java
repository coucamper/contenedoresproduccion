package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.GravedadIncidenciaVO;

public interface GravedadIncidenciaService {

	<S extends GravedadIncidenciaVO> S save(S entity);

	<S extends GravedadIncidenciaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<GravedadIncidenciaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<GravedadIncidenciaVO> findAll();

	Iterable<GravedadIncidenciaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(GravedadIncidenciaVO entity);

	void deleteAll(Iterable<? extends GravedadIncidenciaVO> entities);

	void deleteAll();

}