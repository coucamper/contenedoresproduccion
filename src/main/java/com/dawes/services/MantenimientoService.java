package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.MantenimientoVO;

public interface MantenimientoService {

	<S extends MantenimientoVO> S save(S entity);

	<S extends MantenimientoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<MantenimientoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<MantenimientoVO> findAll();

	Iterable<MantenimientoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(MantenimientoVO entity);

	void deleteAll(Iterable<? extends MantenimientoVO> entities);

	void deleteAll();

}