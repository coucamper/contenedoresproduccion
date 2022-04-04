package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ContratoEmpleadoVO;
import com.dawes.repository.ContratoEmpleadoRepo;
import com.dawes.services.ContratoEmpleadoService;

@Service
public class ContratoEmpleadoServiceImpl implements ContratoEmpleadoRepo, ContratoEmpleadoService {

	@Autowired
	ContratoEmpleadoRepo cer;

	@Override
	public <S extends ContratoEmpleadoVO> S save(S entity) {
		return cer.save(entity);
	}

	@Override
	public <S extends ContratoEmpleadoVO> Optional<S> findOne(Example<S> example) {
		return cer.findOne(example);
	}

	@Override
	public Page<ContratoEmpleadoVO> findAll(Pageable pageable) {
		return cer.findAll(pageable);
	}

	@Override
	public List<ContratoEmpleadoVO> findAll() {
		return cer.findAll();
	}

	@Override
	public List<ContratoEmpleadoVO> findAll(Sort sort) {
		return cer.findAll(sort);
	}

	@Override
	public List<ContratoEmpleadoVO> findAllById(Iterable<Integer> ids) {
		return cer.findAllById(ids);
	}

	@Override
	public <S extends ContratoEmpleadoVO> List<S> saveAll(Iterable<S> entities) {
		return cer.saveAll(entities);
	}

	@Override
	public Optional<ContratoEmpleadoVO> findById(Integer id) {
		return cer.findById(id);
	}

	@Override
	public void flush() {
		cer.flush();
	}

	@Override
	public <S extends ContratoEmpleadoVO> S saveAndFlush(S entity) {
		return cer.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return cer.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<ContratoEmpleadoVO> entities) {
		cer.deleteInBatch(entities);
	}

	@Override
	public <S extends ContratoEmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cer.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		cer.deleteAllInBatch();
	}

	@Override
	public ContratoEmpleadoVO getOne(Integer id) {
		return cer.getOne(id);
	}

	@Override
	public <S extends ContratoEmpleadoVO> long count(Example<S> example) {
		return cer.count(example);
	}

	@Override
	public <S extends ContratoEmpleadoVO> boolean exists(Example<S> example) {
		return cer.exists(example);
	}

	@Override
	public <S extends ContratoEmpleadoVO> List<S> findAll(Example<S> example) {
		return cer.findAll(example);
	}

	@Override
	public long count() {
		return cer.count();
	}

	@Override
	public void deleteById(Integer id) {
		cer.deleteById(id);
	}

	@Override
	public <S extends ContratoEmpleadoVO> List<S> findAll(Example<S> example, Sort sort) {
		return cer.findAll(example, sort);
	}

	@Override
	public void delete(ContratoEmpleadoVO entity) {
		cer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ContratoEmpleadoVO> entities) {
		cer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cer.deleteAll();
	}
	
	
}
