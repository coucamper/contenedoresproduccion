package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.llenadoContVO;

public interface LlenadoContService {

	<S extends llenadoContVO> S save(S entity);

	<S extends llenadoContVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<llenadoContVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<llenadoContVO> findAll();

	Iterable<llenadoContVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(llenadoContVO entity);

	void deleteAll(Iterable<? extends llenadoContVO> entities);

	void deleteAll();

}