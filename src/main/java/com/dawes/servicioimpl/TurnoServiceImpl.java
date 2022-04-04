package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TurnoVO;
import com.dawes.repository.TurnosRepo;
import com.dawes.services.TurnosService;

@Service
public class TurnoServiceImpl implements TurnosRepo, TurnosService {

	@Autowired
	TurnosRepo tr;

	@Override
	public <S extends TurnoVO> S save(S entity) {
		return tr.save(entity);
	}

	@Override
	public <S extends TurnoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tr.saveAll(entities);
	}

	@Override
	public Optional<TurnoVO> findById(Integer id) {
		return tr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tr.existsById(id);
	}

	@Override
	public Iterable<TurnoVO> findAll() {
		return tr.findAll();
	}

	@Override
	public Iterable<TurnoVO> findAllById(Iterable<Integer> ids) {
		return tr.findAllById(ids);
	}

	@Override
	public long count() {
		return tr.count();
	}

	@Override
	public void deleteById(Integer id) {
		tr.deleteById(id);
	}

	@Override
	public void delete(TurnoVO entity) {
		tr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TurnoVO> entities) {
		tr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tr.deleteAll();
	}
	
	

}
