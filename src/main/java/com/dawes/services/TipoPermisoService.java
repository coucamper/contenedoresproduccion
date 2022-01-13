package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoPermisoVO;

public interface TipoPermisoService {

	<S extends TipoPermisoVO> S save(S entity);

	<S extends TipoPermisoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoPermisoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoPermisoVO> findAll();

	Iterable<TipoPermisoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoPermisoVO entity);

	void deleteAll(Iterable<? extends TipoPermisoVO> entities);

	void deleteAll();

}