package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ClientesExportacionesVO;

public interface ClientesExportacionesService {

	<S extends ClientesExportacionesVO> S save(S entity);

	<S extends ClientesExportacionesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ClientesExportacionesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ClientesExportacionesVO> findAll();

	Iterable<ClientesExportacionesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ClientesExportacionesVO entity);

	void deleteAll(Iterable<? extends ClientesExportacionesVO> entities);

	void deleteAll();

}