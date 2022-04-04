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

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.RutaVO;
import com.dawes.repository.RutaRepo;
import com.dawes.services.RutaService;

@Primary
@Service
public class RutaServicioImpl implements RutaRepo, RutaService {

	@Autowired
	RutaRepo rr;

	@Override
	public <S extends RutaVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RutaVO> Optional<S> findOne(Example<S> example) {
		return rr.findOne(example);
	}

	@Override
	public Page<RutaVO> findAll(Pageable pageable) {
		return rr.findAll(pageable);
	}

	@Override
	public List<RutaVO> findAll() {
		return rr.findAll();
	}

	@Override
	public List<RutaVO> findAll(Sort sort) {
		return rr.findAll(sort);
	}

	@Override
	public List<RutaVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
	}

	@Override
	public <S extends RutaVO> List<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RutaVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public void flush() {
		rr.flush();
	}

	@Override
	public <S extends RutaVO> S saveAndFlush(S entity) {
		return rr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<RutaVO> entities) {
		rr.deleteInBatch(entities);
	}

	@Override
	public <S extends RutaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return rr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		rr.deleteAllInBatch();
	}

	@Override
	public RutaVO getOne(Integer id) {
		return rr.getOne(id);
	}

	@Override
	public <S extends RutaVO> long count(Example<S> example) {
		return rr.count(example);
	}

	@Override
	public <S extends RutaVO> boolean exists(Example<S> example) {
		return rr.exists(example);
	}

	@Override
	public <S extends RutaVO> List<S> findAll(Example<S> example) {
		return rr.findAll(example);
	}

	@Override
	public long count() {
		return rr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	@Override
	public <S extends RutaVO> List<S> findAll(Example<S> example, Sort sort) {
		return rr.findAll(example, sort);
	}

	@Override
	public void delete(RutaVO entity) {
		rr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RutaVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}

	


}
