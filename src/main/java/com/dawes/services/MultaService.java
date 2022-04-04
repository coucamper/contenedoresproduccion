package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.MultaVO;

public interface MultaService {

	List<MultaVO> BuscarMultasPorVehiculo(int idvehiculo);

	<S extends MultaVO> S save(S entity);

	<S extends MultaVO> Optional<S> findOne(Example<S> example);

	Page<MultaVO> findAll(Pageable pageable);

	List<MultaVO> findAll();

	List<MultaVO> findAll(Sort sort);

	List<MultaVO> findAllById(Iterable<Integer> ids);

	<S extends MultaVO> List<S> saveAll(Iterable<S> entities);

	Optional<MultaVO> findById(Integer id);

	void flush();

	<S extends MultaVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<MultaVO> entities);

	<S extends MultaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	MultaVO getOne(Integer id);

	<S extends MultaVO> long count(Example<S> example);

	<S extends MultaVO> boolean exists(Example<S> example);

	<S extends MultaVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends MultaVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(MultaVO entity);

	void deleteAll(Iterable<? extends MultaVO> entities);

	void deleteAll();

}