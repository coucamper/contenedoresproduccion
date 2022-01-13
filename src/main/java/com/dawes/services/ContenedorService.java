package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ContenedorVO;

public interface ContenedorService {

	<S extends ContenedorVO> S save(S entity);

	<S extends ContenedorVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ContenedorVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ContenedorVO> findAll();

	Iterable<ContenedorVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ContenedorVO entity);

	void deleteAll(Iterable<? extends ContenedorVO> entities);

	void deleteAll();

}