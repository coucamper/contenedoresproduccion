package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ComarcaVO;
import com.dawes.repository.ComarcaRepo;
import com.dawes.services.ComarcaService;

@Service
public class ComarcaServiceImpl implements ComarcaRepo, ComarcaService {

	@Autowired
	ComarcaRepo cr;

	@Override
	public <S extends ComarcaVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ComarcaVO> Optional<S> findOne(Example<S> example) {
		return cr.findOne(example);
	}

	@Override
	public Page<ComarcaVO> findAll(Pageable pageable) {
		return cr.findAll(pageable);
	}

	@Override
	public List<ComarcaVO> findAll() {
		return cr.findAll();
	}

	@Override
	public List<ComarcaVO> findAll(Sort sort) {
		return cr.findAll(sort);
	}

	@Override
	public List<ComarcaVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public <S extends ComarcaVO> List<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ComarcaVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public void flush() {
		cr.flush();
	}

	@Override
	public <S extends ComarcaVO> S saveAndFlush(S entity) {
		return cr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<ComarcaVO> entities) {
		cr.deleteInBatch(entities);
	}

	@Override
	public <S extends ComarcaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		cr.deleteAllInBatch();
	}

	@Override
	public ComarcaVO getOne(Integer id) {
		return cr.getOne(id);
	}

	@Override
	public <S extends ComarcaVO> long count(Example<S> example) {
		return cr.count(example);
	}

	@Override
	public <S extends ComarcaVO> boolean exists(Example<S> example) {
		return cr.exists(example);
	}

	@Override
	public <S extends ComarcaVO> List<S> findAll(Example<S> example) {
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
	public <S extends ComarcaVO> List<S> findAll(Example<S> example, Sort sort) {
		return cr.findAll(example, sort);
	}

	@Override
	public void delete(ComarcaVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ComarcaVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}

	
	
	

}
