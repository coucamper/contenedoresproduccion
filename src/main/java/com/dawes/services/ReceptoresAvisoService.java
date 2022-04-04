package com.dawes.services;

import java.util.Optional;

public interface ReceptoresAvisoService {

	<S extends ReceptoresAvisoVO> S save(S entity);

	<S extends ReceptoresAvisoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ReceptoresAvisoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ReceptoresAvisoVO> findAll();

	Iterable<ReceptoresAvisoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ReceptoresAvisoVO entity);

	void deleteAll(Iterable<? extends ReceptoresAvisoVO> entities);

	void deleteAll();

}