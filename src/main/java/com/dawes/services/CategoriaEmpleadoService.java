package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.CategoriaEmpleadoVO;

public interface CategoriaEmpleadoService {

	<S extends CategoriaEmpleadoVO> S save(S entity);

	<S extends CategoriaEmpleadoVO> Optional<S> findOne(Example<S> example);

	Page<CategoriaEmpleadoVO> findAll(Pageable pageable);

	List<CategoriaEmpleadoVO> findAll();

	List<CategoriaEmpleadoVO> findAll(Sort sort);

	List<CategoriaEmpleadoVO> findAllById(Iterable<Integer> ids);

	<S extends CategoriaEmpleadoVO> List<S> saveAll(Iterable<S> entities);

	Optional<CategoriaEmpleadoVO> findById(Integer id);

	void flush();

	<S extends CategoriaEmpleadoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<CategoriaEmpleadoVO> entities);

	<S extends CategoriaEmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	CategoriaEmpleadoVO getOne(Integer id);

	<S extends CategoriaEmpleadoVO> long count(Example<S> example);

	<S extends CategoriaEmpleadoVO> boolean exists(Example<S> example);

	<S extends CategoriaEmpleadoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends CategoriaEmpleadoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(CategoriaEmpleadoVO entity);

	void deleteAll(Iterable<? extends CategoriaEmpleadoVO> entities);

	void deleteAll();

}