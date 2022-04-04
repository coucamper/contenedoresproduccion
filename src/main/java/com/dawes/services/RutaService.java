package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.RutaVO;

public interface RutaService {

	<S extends RutaVO> S save(S entity);

	<S extends RutaVO> Optional<S> findOne(Example<S> example);

	Page<RutaVO> findAll(Pageable pageable);

	List<RutaVO> findAll();

	List<RutaVO> findAll(Sort sort);

	List<RutaVO> findAllById(Iterable<Integer> ids);

	<S extends RutaVO> List<S> saveAll(Iterable<S> entities);

	Optional<RutaVO> findById(Integer id);

	void flush();

	<S extends RutaVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<RutaVO> entities);

	<S extends RutaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	RutaVO getOne(Integer id);

	<S extends RutaVO> long count(Example<S> example);

	<S extends RutaVO> boolean exists(Example<S> example);

	<S extends RutaVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends RutaVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(RutaVO entity);

	void deleteAll(Iterable<? extends RutaVO> entities);

	void deleteAll();

}