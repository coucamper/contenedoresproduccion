package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.ComarcaVO;

public interface ComarcaService {

	<S extends ComarcaVO> S save(S entity);

	<S extends ComarcaVO> Optional<S> findOne(Example<S> example);

	Page<ComarcaVO> findAll(Pageable pageable);

	List<ComarcaVO> findAll();

	List<ComarcaVO> findAll(Sort sort);

	List<ComarcaVO> findAllById(Iterable<Integer> ids);

	<S extends ComarcaVO> List<S> saveAll(Iterable<S> entities);

	Optional<ComarcaVO> findById(Integer id);

	void flush();

	<S extends ComarcaVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<ComarcaVO> entities);

	<S extends ComarcaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	ComarcaVO getOne(Integer id);

	<S extends ComarcaVO> long count(Example<S> example);

	<S extends ComarcaVO> boolean exists(Example<S> example);

	<S extends ComarcaVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends ComarcaVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(ComarcaVO entity);

	void deleteAll(Iterable<? extends ComarcaVO> entities);

	void deleteAll();

}