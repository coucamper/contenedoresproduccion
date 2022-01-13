package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.RevisionesVehiculoVO;

public interface RevisionesVehiculoService {

	<S extends RevisionesVehiculoVO> S save(S entity);

	<S extends RevisionesVehiculoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<RevisionesVehiculoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<RevisionesVehiculoVO> findAll();

	Iterable<RevisionesVehiculoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(RevisionesVehiculoVO entity);

	void deleteAll(Iterable<? extends RevisionesVehiculoVO> entities);

	void deleteAll();

}