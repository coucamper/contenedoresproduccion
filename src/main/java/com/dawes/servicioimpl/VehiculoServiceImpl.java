package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.VehiculoVO;
import com.dawes.repository.VehiculoRepo;
import com.dawes.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoRepo, VehiculoService {

	@Autowired
	VehiculoRepo vr;

	@Override
	public <S extends VehiculoVO> S save(S entity) {
		return vr.save(entity);
	}

	@Override
	public <S extends VehiculoVO> Optional<S> findOne(Example<S> example) {
		return vr.findOne(example);
	}

	@Override
	public Page<VehiculoVO> findAll(Pageable pageable) {
		return vr.findAll(pageable);
	}

	@Override
	public List<VehiculoVO> findAll() {
		return vr.findAll();
	}

	@Override
	public List<VehiculoVO> findAll(Sort sort) {
		return vr.findAll(sort);
	}

	@Override
	public List<VehiculoVO> findAllById(Iterable<Integer> ids) {
		return vr.findAllById(ids);
	}

	@Override
	public <S extends VehiculoVO> List<S> saveAll(Iterable<S> entities) {
		return vr.saveAll(entities);
	}

	@Override
	public Optional<VehiculoVO> findById(Integer id) {
		return vr.findById(id);
	}

	@Override
	public void flush() {
		vr.flush();
	}

	@Override
	public <S extends VehiculoVO> S saveAndFlush(S entity) {
		return vr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return vr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<VehiculoVO> entities) {
		vr.deleteInBatch(entities);
	}

	@Override
	public <S extends VehiculoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return vr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		vr.deleteAllInBatch();
	}

	@Override
	public VehiculoVO getOne(Integer id) {
		return vr.getOne(id);
	}

	@Override
	public <S extends VehiculoVO> long count(Example<S> example) {
		return vr.count(example);
	}

	@Override
	public <S extends VehiculoVO> boolean exists(Example<S> example) {
		return vr.exists(example);
	}

	@Override
	public <S extends VehiculoVO> List<S> findAll(Example<S> example) {
		return vr.findAll(example);
	}

	@Override
	public long count() {
		return vr.count();
	}

	@Override
	public void deleteById(Integer id) {
		vr.deleteById(id);
	}

	@Override
	public <S extends VehiculoVO> List<S> findAll(Example<S> example, Sort sort) {
		return vr.findAll(example, sort);
	}

	@Override
	public void delete(VehiculoVO entity) {
		vr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends VehiculoVO> entities) {
		vr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		vr.deleteAll();
	}

	
	
	
}
