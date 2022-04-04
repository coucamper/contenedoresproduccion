package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoMantenimientoVO;

public interface TipoMantenimientoService {

	<S extends TipoMantenimientoVO> S save(S entity);

	<S extends TipoMantenimientoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoMantenimientoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoMantenimientoVO> findAll();

	Iterable<TipoMantenimientoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoMantenimientoVO entity);

	void deleteAll(Iterable<? extends TipoMantenimientoVO> entities);

	void deleteAll();

}