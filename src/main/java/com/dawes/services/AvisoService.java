package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.AvisoVO;

public interface AvisoService {

	<S extends AvisoVO> S save(S entity);

	<S extends AvisoVO> Optional<S> findOne(Example<S> example);

	Page<AvisoVO> findAll(Pageable pageable);

	List<AvisoVO> findAll();

	List<AvisoVO> findAll(Sort sort);

	List<AvisoVO> findAllById(Iterable<Integer> ids);

	<S extends AvisoVO> List<S> saveAll(Iterable<S> entities);

	Optional<AvisoVO> findById(Integer id);

	void flush();

	<S extends AvisoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<AvisoVO> entities);

	<S extends AvisoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	AvisoVO getOne(Integer id);

	<S extends AvisoVO> long count(Example<S> example);

	<S extends AvisoVO> boolean exists(Example<S> example);

	<S extends AvisoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends AvisoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(AvisoVO entity);

	void deleteAll(Iterable<? extends AvisoVO> entities);

	void deleteAll();

}