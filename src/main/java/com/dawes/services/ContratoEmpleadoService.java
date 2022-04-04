package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.ContratoEmpleadoVO;

public interface ContratoEmpleadoService {

	<S extends ContratoEmpleadoVO> S save(S entity);

	<S extends ContratoEmpleadoVO> Optional<S> findOne(Example<S> example);

	Page<ContratoEmpleadoVO> findAll(Pageable pageable);

	List<ContratoEmpleadoVO> findAll();

	List<ContratoEmpleadoVO> findAll(Sort sort);

	List<ContratoEmpleadoVO> findAllById(Iterable<Integer> ids);

	<S extends ContratoEmpleadoVO> List<S> saveAll(Iterable<S> entities);

	Optional<ContratoEmpleadoVO> findById(Integer id);

	void flush();

	<S extends ContratoEmpleadoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<ContratoEmpleadoVO> entities);

	<S extends ContratoEmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	ContratoEmpleadoVO getOne(Integer id);

	<S extends ContratoEmpleadoVO> long count(Example<S> example);

	<S extends ContratoEmpleadoVO> boolean exists(Example<S> example);

	<S extends ContratoEmpleadoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends ContratoEmpleadoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(ContratoEmpleadoVO entity);

	void deleteAll(Iterable<? extends ContratoEmpleadoVO> entities);

	void deleteAll();

}