package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;

import com.dawes.modelos.RolVO;
import com.dawes.repository.RolRepo;
import com.dawes.services.RolService;

@Service
public class RolServiceImpl implements RolRepo, RolService {

	@Autowired
	RolRepo rr;

	@Override
	public <S extends RolVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RolVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public Iterable<RolVO> findAll() {
		return rr.findAll();
	}

	@Override
	public Iterable<RolVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
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
	public void delete(RolVO entity) {
		rr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RolVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}
	
	
	

}
