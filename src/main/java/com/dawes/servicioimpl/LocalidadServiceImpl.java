package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.LocalidadVO;
import com.dawes.repository.LocalidadRepo;
import com.dawes.services.LocalidadService;

@Service
public class LocalidadServiceImpl implements LocalidadRepo, LocalidadService {

	@Autowired
	LocalidadRepo lr;

	@Override
	public <S extends LocalidadVO> S save(S entity) {
		return lr.save(entity);
	}

	@Override
	public <S extends LocalidadVO> Iterable<S> saveAll(Iterable<S> entities) {
		return lr.saveAll(entities);
	}

	@Override
	public Optional<LocalidadVO> findById(Integer id) {
		return lr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lr.existsById(id);
	}

	@Override
	public Iterable<LocalidadVO> findAll() {
		return lr.findAll();
	}

	@Override
	public Iterable<LocalidadVO> findAllById(Iterable<Integer> ids) {
		return lr.findAllById(ids);
	}

	@Override
	public long count() {
		return lr.count();
	}

	@Override
	public void deleteById(Integer id) {
		lr.deleteById(id);
	}

	@Override
	public void delete(LocalidadVO entity) {
		lr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends LocalidadVO> entities) {
		lr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lr.deleteAll();
	}
	
	

}
