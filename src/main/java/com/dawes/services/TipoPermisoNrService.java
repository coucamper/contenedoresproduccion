package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoPermisoNrVO;

public interface TipoPermisoNrService {

	<S extends TipoPermisoNrVO> S save(S entity);

	<S extends TipoPermisoNrVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoPermisoNrVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoPermisoNrVO> findAll();

	Iterable<TipoPermisoNrVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoPermisoNrVO entity);

	void deleteAll(Iterable<? extends TipoPermisoNrVO> entities);

	void deleteAll();

}