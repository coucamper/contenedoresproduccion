package com.dawes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.VehiculosPesajesVO;

public interface VehiculosPesajesService {

	Long sumPesajes(int idruta);

	<S extends VehiculosPesajesVO> S save(S entity);

	<S extends VehiculosPesajesVO> Optional<S> findOne(Example<S> example);

	Page<VehiculosPesajesVO> findAll(Pageable pageable);

	List<VehiculosPesajesVO> findAll();

	List<VehiculosPesajesVO> findAll(Sort sort);

	List<VehiculosPesajesVO> findAllById(Iterable<Integer> ids);

	<S extends VehiculosPesajesVO> List<S> saveAll(Iterable<S> entities);

	Optional<VehiculosPesajesVO> findById(Integer id);

	void flush();

	<S extends VehiculosPesajesVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<VehiculosPesajesVO> entities);

	<S extends VehiculosPesajesVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	VehiculosPesajesVO getOne(Integer id);

	<S extends VehiculosPesajesVO> long count(Example<S> example);

	<S extends VehiculosPesajesVO> boolean exists(Example<S> example);

	<S extends VehiculosPesajesVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends VehiculosPesajesVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(VehiculosPesajesVO entity);

	void deleteAll(Iterable<? extends VehiculosPesajesVO> entities);

	void deleteAll();

	Long sumPesajes();

}