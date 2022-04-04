package com.dawes.servicioimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.RutaVO;
import com.dawes.repository.PesajeRepo;
import com.dawes.services.PesajeService;

@Service
public class PesajeServiceImpl implements PesajeRepo, PesajeService {

	@Autowired
	PesajeRepo pr;

	@Override
	public Long sumPesajes() {
		return pr.sumPesajes();
	}

	@Override
	public List<PesajeVO> findByfechapesajeBetweenSuma(LocalDate fechainicio, LocalDate fechafin) {
		return pr.findByfechapesajeBetweenSuma(fechainicio, fechafin);
	}

	@Override
	public List<PesajeVO> findByfechapesajeBetween(LocalDate fechainicio, LocalDate fechafin) {
		return pr.findByfechapesajeBetween(fechainicio, fechafin);
	}

	@Override
	public <S extends PesajeVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends PesajeVO> Optional<S> findOne(Example<S> example) {
		return pr.findOne(example);
	}

	@Override
	public Page<PesajeVO> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}

	@Override
	public List<PesajeVO> findAll() {
		return pr.findAll();
	}

	@Override
	public List<PesajeVO> findAll(Sort sort) {
		return pr.findAll(sort);
	}

	@Override
	public List<PesajeVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public <S extends PesajeVO> List<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public Optional<PesajeVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public void flush() {
		pr.flush();
	}

	@Override
	public <S extends PesajeVO> S saveAndFlush(S entity) {
		return pr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<PesajeVO> entities) {
		pr.deleteInBatch(entities);
	}

	@Override
	public <S extends PesajeVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return pr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		pr.deleteAllInBatch();
	}

	@Override
	public PesajeVO getOne(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public <S extends PesajeVO> long count(Example<S> example) {
		return pr.count(example);
	}

	@Override
	public <S extends PesajeVO> boolean exists(Example<S> example) {
		return pr.exists(example);
	}

	@Override
	public <S extends PesajeVO> List<S> findAll(Example<S> example) {
		return pr.findAll(example);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public <S extends PesajeVO> List<S> findAll(Example<S> example, Sort sort) {
		return pr.findAll(example, sort);
	}

	@Override
	public void delete(PesajeVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PesajeVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}

	@Override
	public PesajeVO findByFechapesajeAndOperarioAndRuta(LocalDate fechapesaje, EmpleadoVO operario, RutaVO ruta) {
		return pr.findByFechapesajeAndOperarioAndRuta(fechapesaje, operario, ruta);
	}


	
	

}
