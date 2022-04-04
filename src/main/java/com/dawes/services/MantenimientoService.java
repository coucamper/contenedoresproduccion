package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.MantenimientoVO;

public interface MantenimientoService {

	List<MantenimientoVO> BuscarMantenimientosVehiculo(int idvehiculo);

	<S extends MantenimientoVO> S save(S entity);

	<S extends MantenimientoVO> Optional<S> findOne(Example<S> example);

	Page<MantenimientoVO> findAll(Pageable pageable);

	List<MantenimientoVO> findAll();

	List<MantenimientoVO> findAll(Sort sort);

	List<MantenimientoVO> findAllById(Iterable<Integer> ids);

	<S extends MantenimientoVO> List<S> saveAll(Iterable<S> entities);

	Optional<MantenimientoVO> findById(Integer id);

	void flush();

	<S extends MantenimientoVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<MantenimientoVO> entities);

	<S extends MantenimientoVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	MantenimientoVO getOne(Integer id);

	<S extends MantenimientoVO> long count(Example<S> example);

	<S extends MantenimientoVO> boolean exists(Example<S> example);

	<S extends MantenimientoVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends MantenimientoVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(MantenimientoVO entity);

	void deleteAll(Iterable<? extends MantenimientoVO> entities);

	void deleteAll();

}