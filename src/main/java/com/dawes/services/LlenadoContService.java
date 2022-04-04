package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.LlenadoContVO;

public interface LlenadoContService {

	<S extends LlenadoContVO> S save(S entity);

	<S extends LlenadoContVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<LlenadoContVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<LlenadoContVO> findAll();

	Iterable<LlenadoContVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(LlenadoContVO entity);

	void deleteAll(Iterable<? extends LlenadoContVO> entities);

	void deleteAll();

}