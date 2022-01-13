package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.VehiculoVO;

public interface VehiculoService {

	<S extends VehiculoVO> S save(S entity);

	<S extends VehiculoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<VehiculoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<VehiculoVO> findAll();

	Iterable<VehiculoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(VehiculoVO entity);

	void deleteAll(Iterable<? extends VehiculoVO> entities);

	void deleteAll();

}