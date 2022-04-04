package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.repository.EmpleadoRepo;
import com.dawes.services.EmpleadoService;


@Primary
@Service
public class EmpleadoServiceImpl implements EmpleadoRepo, EmpleadoService {
	
	@Autowired
	EmpleadoRepo er;

	@Override
	public <S extends EmpleadoVO> S save(S entity) {
		return er.save(entity);
	}

	@Override
	public <S extends EmpleadoVO> Optional<S> findOne(Example<S> example) {
		return er.findOne(example);
	}

	@Override
	public Page<EmpleadoVO> findAll(Pageable pageable) {
		return er.findAll(pageable);
	}

	@Override
	public List<EmpleadoVO> findAll() {
		return er.findAll();
	}

	@Override
	public List<EmpleadoVO> findAll(Sort sort) {
		return er.findAll(sort);
	}

	@Override
	public List<EmpleadoVO> findAllById(Iterable<Integer> ids) {
		return er.findAllById(ids);
	}

	@Override
	public <S extends EmpleadoVO> List<S> saveAll(Iterable<S> entities) {
		return er.saveAll(entities);
	}

	@Override
	public Optional<EmpleadoVO> findById(Integer id) {
		return er.findById(id);
	}

	@Override
	public void flush() {
		er.flush();
	}

	@Override
	public <S extends EmpleadoVO> S saveAndFlush(S entity) {
		return er.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return er.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<EmpleadoVO> entities) {
		er.deleteInBatch(entities);
	}

	@Override
	public <S extends EmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return er.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		er.deleteAllInBatch();
	}

	@Override
	public EmpleadoVO getOne(Integer id) {
		return er.getOne(id);
	}

	@Override
	public <S extends EmpleadoVO> long count(Example<S> example) {
		return er.count(example);
	}

	@Override
	public <S extends EmpleadoVO> boolean exists(Example<S> example) {
		return er.exists(example);
	}

	@Override
	public <S extends EmpleadoVO> List<S> findAll(Example<S> example) {
		return er.findAll(example);
	}

	@Override
	public long count() {
		return er.count();
	}

	@Override
	public void deleteById(Integer id) {
		er.deleteById(id);
	}

	@Override
	public <S extends EmpleadoVO> List<S> findAll(Example<S> example, Sort sort) {
		return er.findAll(example, sort);
	}

	@Override
	public void delete(EmpleadoVO entity) {
		er.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends EmpleadoVO> entities) {
		er.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}

	@Override
	public EmpleadoVO findByNif(String nif) {
		return er.findByNif(nif);
	}

	
	
	

}
