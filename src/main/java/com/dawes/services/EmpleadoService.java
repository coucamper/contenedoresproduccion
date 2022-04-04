package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.EmpleadoVO;

public interface EmpleadoService {

	<S extends EmpleadoVO> S save(S entity);

	<S extends EmpleadoVO> Optional<S> findOne(Example<S> example);

	Page<EmpleadoVO> findAll(Pageable pageable);

	List<EmpleadoVO> findAll();

	List<EmpleadoVO> findAll(Sort sort);

	List<EmpleadoVO> findAllById(Iterable<Integer> ids);

	<S extends EmpleadoVO> List<S> saveAll(Iterable<S> entities);

	Optional<EmpleadoVO> findById(Integer id);

	void flush();

	<S extends EmpleadoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<EmpleadoVO> entities);

	<S extends EmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	EmpleadoVO getOne(Integer id);

	<S extends EmpleadoVO> long count(Example<S> example);

	<S extends EmpleadoVO> boolean exists(Example<S> example);

	<S extends EmpleadoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends EmpleadoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(EmpleadoVO entity);

	void deleteAll(Iterable<? extends EmpleadoVO> entities);

	void deleteAll();

	EmpleadoVO findByNif(String nif);

}