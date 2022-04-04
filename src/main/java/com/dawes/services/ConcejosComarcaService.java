package com.dawes.services;

import java.util.List;
import java.util.Optional;

import com.dawes.modelos.ConcejosComarcaVO;

public interface ConcejosComarcaService {

	<S extends ConcejosComarcaVO> S save(S entity);

	<S extends ConcejosComarcaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ConcejosComarcaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ConcejosComarcaVO> findAll();

	Iterable<ConcejosComarcaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ConcejosComarcaVO entity);

	void deleteAll(Iterable<? extends ConcejosComarcaVO> entities);

	void deleteAll();

	List<ConcejosComarcaVO> ConcejosPorComarca(int idcomarca);

}