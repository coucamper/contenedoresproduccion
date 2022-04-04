package com.dawes.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelos.TurnoEmpleadoVO;

public interface TurnoEmpleadoService {

	<S extends TurnoEmpleadoVO> S save(S entity);

	<S extends TurnoEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TurnoEmpleadoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TurnoEmpleadoVO> findAll();

	Iterable<TurnoEmpleadoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TurnoEmpleadoVO entity);

	void deleteAll(Iterable<? extends TurnoEmpleadoVO> entities);

	void deleteAll();

	List<TurnoEmpleadoVO> findByfechainicioturnoBetween(LocalDate fechainicioturno, LocalDate fechafinturno);

}