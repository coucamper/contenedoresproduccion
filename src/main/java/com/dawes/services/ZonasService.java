package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ZonasVO;

public interface ZonasService {

	<S extends ZonasVO> S save(S entity);

	<S extends ZonasVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ZonasVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ZonasVO> findAll();

	Iterable<ZonasVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ZonasVO entity);

	void deleteAll(Iterable<? extends ZonasVO> entities);

	void deleteAll();

}