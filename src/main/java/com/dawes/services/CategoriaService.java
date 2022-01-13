package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.CategoriaVO;

public interface CategoriaService {

	<S extends CategoriaVO> S save(S entity);

	<S extends CategoriaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<CategoriaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<CategoriaVO> findAll();

	Iterable<CategoriaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(CategoriaVO entity);

	void deleteAll(Iterable<? extends CategoriaVO> entities);

	void deleteAll();

}