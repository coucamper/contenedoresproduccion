package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.AveriasVO;

public interface AveriasService {

	<S extends AveriasVO> S save(S entity);

	<S extends AveriasVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<AveriasVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<AveriasVO> findAll();

	Iterable<AveriasVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(AveriasVO entity);

	void deleteAll(Iterable<? extends AveriasVO> entities);

	void deleteAll();

}