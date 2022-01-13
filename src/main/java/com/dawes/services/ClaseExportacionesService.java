package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ClaseExportacionesVO;

public interface ClaseExportacionesService {

	<S extends ClaseExportacionesVO> S save(S entity);

	<S extends ClaseExportacionesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ClaseExportacionesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ClaseExportacionesVO> findAll();

	Iterable<ClaseExportacionesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ClaseExportacionesVO entity);

	void deleteAll(Iterable<? extends ClaseExportacionesVO> entities);

	void deleteAll();

}