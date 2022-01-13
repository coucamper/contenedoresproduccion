package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.AvisoVO;

public interface AvisoService {

	<S extends AvisoVO> S save(S entity);

	<S extends AvisoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<AvisoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<AvisoVO> findAll();

	Iterable<AvisoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(AvisoVO entity);

	void deleteAll(Iterable<? extends AvisoVO> entities);

	void deleteAll();

}