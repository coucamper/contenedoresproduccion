package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoIncidenciaVO;

public interface TipoIncidenciaService {

	<S extends TipoIncidenciaVO> S save(S entity);

	<S extends TipoIncidenciaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoIncidenciaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoIncidenciaVO> findAll();

	Iterable<TipoIncidenciaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoIncidenciaVO entity);

	void deleteAll(Iterable<? extends TipoIncidenciaVO> entities);

	void deleteAll();

}