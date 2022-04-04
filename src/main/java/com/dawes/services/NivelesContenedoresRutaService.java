package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.NivelesContenedoresVO;

public interface NivelesContenedoresRutaService {

	List<NivelesContenedoresVO> NivelesContenedoresPorRuta(int idruta);

	List<NivelesContenedoresVO> findAllByIdruta(int idruta, Pageable pageable);

	<S extends NivelesContenedoresVO> S save(S entity);

	<S extends NivelesContenedoresVO> Optional<S> findOne(Example<S> example);

	Page<NivelesContenedoresVO> findAll(Pageable pageable);

	List<NivelesContenedoresVO> findAll();

	List<NivelesContenedoresVO> findAll(Sort sort);

	List<NivelesContenedoresVO> findAllById(Iterable<Integer> ids);

	<S extends NivelesContenedoresVO> List<S> saveAll(Iterable<S> entities);

	Optional<NivelesContenedoresVO> findById(Integer id);

	void flush();

	<S extends NivelesContenedoresVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<NivelesContenedoresVO> entities);

	<S extends NivelesContenedoresVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	NivelesContenedoresVO getOne(Integer id);

	<S extends NivelesContenedoresVO> long count(Example<S> example);

	<S extends NivelesContenedoresVO> boolean exists(Example<S> example);

	<S extends NivelesContenedoresVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends NivelesContenedoresVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(NivelesContenedoresVO entity);

	void deleteAll(Iterable<? extends NivelesContenedoresVO> entities);

	void deleteAll();

}