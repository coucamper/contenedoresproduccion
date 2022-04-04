package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.ContenedorVO;

public interface ContenedorService {

	<S extends ContenedorVO> S save(S entity);

	<S extends ContenedorVO> Optional<S> findOne(Example<S> example);

	Page<ContenedorVO> findAll(Pageable pageable);

	List<ContenedorVO> findAll();

	List<ContenedorVO> findAll(Sort sort);

	List<ContenedorVO> findAllById(Iterable<Integer> ids);

	<S extends ContenedorVO> List<S> saveAll(Iterable<S> entities);

	Optional<ContenedorVO> findById(Integer id);

	void flush();

	<S extends ContenedorVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<ContenedorVO> entities);

	<S extends ContenedorVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	ContenedorVO getOne(Integer id);

	<S extends ContenedorVO> long count(Example<S> example);

	<S extends ContenedorVO> boolean exists(Example<S> example);

	<S extends ContenedorVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends ContenedorVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(ContenedorVO entity);

	void deleteAll(Iterable<? extends ContenedorVO> entities);

	void deleteAll();

}