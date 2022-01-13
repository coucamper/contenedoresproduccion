package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.PesajeVO;

public interface PesajeService {

	<S extends PesajeVO> S save(S entity);

	<S extends PesajeVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PesajeVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PesajeVO> findAll();

	Iterable<PesajeVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PesajeVO entity);

	void deleteAll(Iterable<? extends PesajeVO> entities);

	void deleteAll();

	Long sumPesajes();

}