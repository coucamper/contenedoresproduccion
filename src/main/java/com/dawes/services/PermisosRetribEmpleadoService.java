package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.PermisosRetribuidosEmpleadoVO;

public interface PermisosRetribEmpleadoService {

	<S extends PermisosRetribuidosEmpleadoVO> S save(S entity);

	<S extends PermisosRetribuidosEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PermisosRetribuidosEmpleadoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PermisosRetribuidosEmpleadoVO> findAll();

	Iterable<PermisosRetribuidosEmpleadoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PermisosRetribuidosEmpleadoVO entity);

	void deleteAll(Iterable<? extends PermisosRetribuidosEmpleadoVO> entities);

	void deleteAll();

}