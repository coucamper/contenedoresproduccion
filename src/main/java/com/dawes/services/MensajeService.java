package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.MensajeVO;

public interface MensajeService {

	<S extends MensajeVO> S save(S entity);

	<S extends MensajeVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<MensajeVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<MensajeVO> findAll();

	Iterable<MensajeVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(MensajeVO entity);

	void deleteAll(Iterable<? extends MensajeVO> entities);

	void deleteAll();

}