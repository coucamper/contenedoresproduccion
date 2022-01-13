package com.dawes.services;

import java.util.List;
import java.util.Optional;

import com.dawes.modelos.ExportVO;

public interface ExportacionService {

	<S extends ExportVO> S save(S entity);

	<S extends ExportVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ExportVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ExportVO> findAll();

	Iterable<ExportVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ExportVO entity);

	void deleteAll(Iterable<? extends ExportVO> entities);

	void deleteAll();

	Long sumPesosLocalesPorCliente(int idcliente);

	List<ExportVO> findAllByEstadopago(String estadopago);

	Long estadopago(String estadopago);

}