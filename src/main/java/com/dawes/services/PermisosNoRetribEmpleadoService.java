package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.PermisosNoRetribEmpleadoVO;

public interface PermisosNoRetribEmpleadoService {

	<S extends PermisosNoRetribEmpleadoVO> S save(S entity);

	<S extends PermisosNoRetribEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PermisosNoRetribEmpleadoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PermisosNoRetribEmpleadoVO> findAll();

	Iterable<PermisosNoRetribEmpleadoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PermisosNoRetribEmpleadoVO entity);

	void deleteAll(Iterable<? extends PermisosNoRetribEmpleadoVO> entities);

	void deleteAll();

}