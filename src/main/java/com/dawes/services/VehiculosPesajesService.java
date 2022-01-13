package com.dawes.services;

import java.util.Optional;

import com.dawes.modelos.VehiculosPesajesVO;

public interface VehiculosPesajesService {

	<S extends VehiculosPesajesVO> S save(S entity);

	<S extends VehiculosPesajesVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<VehiculosPesajesVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<VehiculosPesajesVO> findAll();

	Iterable<VehiculosPesajesVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(VehiculosPesajesVO entity);

	void deleteAll(Iterable<? extends VehiculosPesajesVO> entities);

	void deleteAll();

	Long sumPesajes();

	Long sumPesajes(int idruta);

}