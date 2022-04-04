package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.PolizaVO;

public interface PolizaService {

	Optional<PolizaVO> BuscarPolizaPorIdVehiculo(int idvehiculo);

	<S extends PolizaVO> S save(S entity);

	<S extends PolizaVO> Optional<S> findOne(Example<S> example);

	Page<PolizaVO> findAll(Pageable pageable);

	List<PolizaVO> findAll();

	List<PolizaVO> findAll(Sort sort);

	List<PolizaVO> findAllById(Iterable<Integer> ids);

	<S extends PolizaVO> List<S> saveAll(Iterable<S> entities);

	Optional<PolizaVO> findById(Integer id);

	void flush();

	<S extends PolizaVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<PolizaVO> entities);

	<S extends PolizaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	PolizaVO getOne(Integer id);

	<S extends PolizaVO> long count(Example<S> example);

	<S extends PolizaVO> boolean exists(Example<S> example);

	<S extends PolizaVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends PolizaVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(PolizaVO entity);

	void deleteAll(Iterable<? extends PolizaVO> entities);

	void deleteAll();

}