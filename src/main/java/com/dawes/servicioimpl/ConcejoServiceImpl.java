package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.modelos.ConcejoVO;
import com.dawes.repository.ConcejoRepo;
import com.dawes.services.ConcejoService;

@Service
public class ConcejoServiceImpl implements ConcejoRepo, ConcejoService{
	
	@Autowired
	ConcejoRepo cr;

	@Override
	public <S extends ConcejoVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ConcejoVO> Optional<S> findOne(Example<S> example) {
		return cr.findOne(example);
	}

	@Override
	public Page<ConcejoVO> findAll(Pageable pageable) {
		return cr.findAll(pageable);
	}

	@Override
	public List<ConcejoVO> findAll() {
		return cr.findAll();
	}

	@Override
	public List<ConcejoVO> findAll(Sort sort) {
		return cr.findAll(sort);
	}

	@Override
	public List<ConcejoVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public <S extends ConcejoVO> List<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ConcejoVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public void flush() {
		cr.flush();
	}

	@Override
	public <S extends ConcejoVO> S saveAndFlush(S entity) {
		return cr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<ConcejoVO> entities) {
		cr.deleteInBatch(entities);
	}

	@Override
	public <S extends ConcejoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		cr.deleteAllInBatch();
	}

	@Override
	public ConcejoVO getOne(Integer id) {
		return cr.getOne(id);
	}

	@Override
	public <S extends ConcejoVO> long count(Example<S> example) {
		return cr.count(example);
	}

	@Override
	public <S extends ConcejoVO> boolean exists(Example<S> example) {
		return cr.exists(example);
	}

	@Override
	public <S extends ConcejoVO> List<S> findAll(Example<S> example) {
		return cr.findAll(example);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public <S extends ConcejoVO> List<S> findAll(Example<S> example, Sort sort) {
		return cr.findAll(example, sort);
	}

	@Override
	public void delete(ConcejoVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ConcejoVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}


	
}
