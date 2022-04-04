package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.TipoImportanciaMensajeVO;

public interface TipoImportanciaMensajeService {

	<S extends TipoImportanciaMensajeVO> S save(S entity);

	<S extends TipoImportanciaMensajeVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TipoImportanciaMensajeVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TipoImportanciaMensajeVO> findAll();

	Iterable<TipoImportanciaMensajeVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TipoImportanciaMensajeVO entity);

	void deleteAll(Iterable<? extends TipoImportanciaMensajeVO> entities);

	void deleteAll();

}