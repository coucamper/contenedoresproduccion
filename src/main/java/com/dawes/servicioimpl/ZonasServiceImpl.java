package com.dawes.servicioimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ZonasVO;
import com.dawes.repository.ZonasRepo;
import com.dawes.services.ZonasService;

@Service
public class ZonasServiceImpl implements ZonasRepo, ZonasService {

	@Autowired
	ZonasRepo zr;

	@Override
	public <S extends ZonasVO> S save(S entity) {
		return zr.save(entity);
	}

	@Override
	public <S extends ZonasVO> Iterable<S> saveAll(Iterable<S> entities) {
		return zr.saveAll(entities);
	}

	@Override
	public Optional<ZonasVO> findById(Integer id) {
		return zr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return zr.existsById(id);
	}

	@Override
	public Iterable<ZonasVO> findAll() {
		return zr.findAll();
	}

	@Override
	public Iterable<ZonasVO> findAllById(Iterable<Integer> ids) {
		return zr.findAllById(ids);
	}

	@Override
	public long count() {
		return zr.count();
	}

	@Override
	public void deleteById(Integer id) {
		zr.deleteById(id);
	}

	@Override
	public void delete(ZonasVO entity) {
		zr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ZonasVO> entities) {
		zr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		zr.deleteAll();
	}
	
	
}
