package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.AvisoVO;
import com.dawes.repository.AvisoRepo;
import com.dawes.services.AvisoService;

@Service
public class AvisoServiceImpl implements AvisoRepo, AvisoService {
	
	@Autowired
	AvisoRepo ar;

	@Override
	public <S extends AvisoVO> S save(S entity) {
		return ar.save(entity);
	}

	@Override
	public <S extends AvisoVO> Optional<S> findOne(Example<S> example) {
		return ar.findOne(example);
	}

	@Override
	public Page<AvisoVO> findAll(Pageable pageable) {
		return ar.findAll(pageable);
	}

	@Override
	public List<AvisoVO> findAll() {
		return ar.findAll();
	}

	@Override
	public List<AvisoVO> findAll(Sort sort) {
		return ar.findAll(sort);
	}

	@Override
	public List<AvisoVO> findAllById(Iterable<Integer> ids) {
		return ar.findAllById(ids);
	}

	@Override
	public <S extends AvisoVO> List<S> saveAll(Iterable<S> entities) {
		return ar.saveAll(entities);
	}

	@Override
	public Optional<AvisoVO> findById(Integer id) {
		return ar.findById(id);
	}

	@Override
	public void flush() {
		ar.flush();
	}

	@Override
	public <S extends AvisoVO> S saveAndFlush(S entity) {
		return ar.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return ar.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<AvisoVO> entities) {
		ar.deleteInBatch(entities);
	}

	@Override
	public <S extends AvisoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return ar.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		ar.deleteAllInBatch();
	}

	@Override
	public AvisoVO getOne(Integer id) {
		return ar.getOne(id);
	}

	@Override
	public <S extends AvisoVO> long count(Example<S> example) {
		return ar.count(example);
	}

	@Override
	public <S extends AvisoVO> boolean exists(Example<S> example) {
		return ar.exists(example);
	}

	@Override
	public <S extends AvisoVO> List<S> findAll(Example<S> example) {
		return ar.findAll(example);
	}

	@Override
	public long count() {
		return ar.count();
	}

	@Override
	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

	@Override
	public <S extends AvisoVO> List<S> findAll(Example<S> example, Sort sort) {
		return ar.findAll(example, sort);
	}

	@Override
	public void delete(AvisoVO entity) {
		ar.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends AvisoVO> entities) {
		ar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ar.deleteAll();
	}



}
