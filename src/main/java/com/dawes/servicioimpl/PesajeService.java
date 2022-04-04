package com.dawes.servicioimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.RutaVO;

public interface PesajeService {

	Long sumPesajes();

	List<PesajeVO> findByfechapesajeBetweenSuma(LocalDate fechainicio, LocalDate fechafin);

	List<PesajeVO> findByfechapesajeBetween(LocalDate fechainicio, LocalDate fechafin);

	<S extends PesajeVO> S save(S entity);

	<S extends PesajeVO> Optional<S> findOne(Example<S> example);

	Page<PesajeVO> findAll(Pageable pageable);

	List<PesajeVO> findAll();

	List<PesajeVO> findAll(Sort sort);

	List<PesajeVO> findAllById(Iterable<Integer> ids);

	<S extends PesajeVO> List<S> saveAll(Iterable<S> entities);

	Optional<PesajeVO> findById(Integer id);

	void flush();

	<S extends PesajeVO> S saveAndFlush(S entity);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<PesajeVO> entities);

	<S extends PesajeVO> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteAllInBatch();

	PesajeVO getOne(Integer id);

	<S extends PesajeVO> long count(Example<S> example);

	<S extends PesajeVO> boolean exists(Example<S> example);

	<S extends PesajeVO> List<S> findAll(Example<S> example);

	long count();

	void deleteById(Integer id);

	<S extends PesajeVO> List<S> findAll(Example<S> example, Sort sort);

	void delete(PesajeVO entity);

	void deleteAll(Iterable<? extends PesajeVO> entities);

	void deleteAll();

	PesajeVO findByFechapesajeAndOperarioAndRuta(LocalDate fechapesaje, EmpleadoVO operario, RutaVO ruta);

}