package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.UsuarioVO;

public interface UsuarioService {

	<S extends UsuarioVO> S save(S entity);

	<S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioVO> findAll();

	Iterable<UsuarioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioVO entity);

	void deleteAll(Iterable<? extends UsuarioVO> entities);

	void deleteAll();

}