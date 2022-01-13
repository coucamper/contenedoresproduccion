package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.ClienteVO;

public interface ClienteService {

	<S extends ClienteVO> S save(S entity);

	<S extends ClienteVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ClienteVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ClienteVO> findAll();

	Iterable<ClienteVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ClienteVO entity);

	void deleteAll(Iterable<? extends ClienteVO> entities);

	void deleteAll();

}