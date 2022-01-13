package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.PlanningVacacionesVO;

public interface PlanningVacacionesService {

	<S extends PlanningVacacionesVO> S save(S entity);

	<S extends PlanningVacacionesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<PlanningVacacionesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<PlanningVacacionesVO> findAll();

	Iterable<PlanningVacacionesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(PlanningVacacionesVO entity);

	void deleteAll(Iterable<? extends PlanningVacacionesVO> entities);

	void deleteAll();

}