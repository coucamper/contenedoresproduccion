package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.PlanningVacacionesVO;

public interface PlanningVacacionesService {

	List<PlanningVacacionesVO> BuscarVacacionesEmpleado(int idempleado);

	<S extends PlanningVacacionesVO> S save(S entity);

	<S extends PlanningVacacionesVO> Optional<S> findOne(Example<S> example);

	Page<PlanningVacacionesVO> findAll(Pageable pageable);

	List<PlanningVacacionesVO> findAll();

	List<PlanningVacacionesVO> findAll(Sort sort);

	List<PlanningVacacionesVO> findAllById(Iterable<Integer> ids);

	<S extends PlanningVacacionesVO> List<S> saveAll(Iterable<S> entities);

	Optional<PlanningVacacionesVO> findById(Integer id);

	void flush();

	<S extends PlanningVacacionesVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<PlanningVacacionesVO> entities);

	<S extends PlanningVacacionesVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	PlanningVacacionesVO getOne(Integer id);

	<S extends PlanningVacacionesVO> long count(Example<S> example);

	<S extends PlanningVacacionesVO> boolean exists(Example<S> example);

	<S extends PlanningVacacionesVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends PlanningVacacionesVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(PlanningVacacionesVO entity);

	void deleteAll(Iterable<? extends PlanningVacacionesVO> entities);

	void deleteAll();

}