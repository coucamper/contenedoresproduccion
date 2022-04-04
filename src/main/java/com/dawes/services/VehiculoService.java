package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.VehiculoVO;

public interface VehiculoService {

	<S extends VehiculoVO> S save(S entity);

	<S extends VehiculoVO> Optional<S> findOne(Example<S> example);

	Page<VehiculoVO> findAll(Pageable pageable);

	List<VehiculoVO> findAll();

	List<VehiculoVO> findAll(Sort sort);

	List<VehiculoVO> findAllById(Iterable<Integer> ids);

	<S extends VehiculoVO> List<S> saveAll(Iterable<S> entities);

	Optional<VehiculoVO> findById(Integer id);

	void flush();

	<S extends VehiculoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<VehiculoVO> entities);

	<S extends VehiculoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	VehiculoVO getOne(Integer id);

	<S extends VehiculoVO> long count(Example<S> example);

	<S extends VehiculoVO> boolean exists(Example<S> example);

	<S extends VehiculoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends VehiculoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(VehiculoVO entity);

	void deleteAll(Iterable<? extends VehiculoVO> entities);

	void deleteAll();

}