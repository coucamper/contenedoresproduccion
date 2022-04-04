package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoContratoVO;

public interface TipoContratoService {

	<S extends TipoContratoVO> S save(S entity);

	<S extends TipoContratoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoContratoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoContratoVO> findAll();

	Iterable<TipoContratoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoContratoVO entity);

	void deleteAll(Iterable<? extends TipoContratoVO> entities);

	void deleteAll();

}