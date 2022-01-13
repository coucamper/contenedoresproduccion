package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.llenadosRutaVO;
import com.dawes.repository.LlenadosRutaRepo;
import com.dawes.services.llenadosService;

@Service
public class llenadosRutaServiceImpl implements LlenadosRutaRepo, llenadosService {
	
	@Autowired
	LlenadosRutaRepo llr;

	@Override
	public <S extends llenadosRutaVO> S save(S entity) {
		return llr.save(entity);
	}

	@Override
	public <S extends llenadosRutaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return llr.saveAll(entities);
	}

	@Override
	public Optional<llenadosRutaVO> findById(Integer id) {
		return llr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return llr.existsById(id);
	}

	@Override
	public Iterable<llenadosRutaVO> findAll() {
		return llr.findAll();
	}

	@Override
	public Iterable<llenadosRutaVO> findAllById(Iterable<Integer> ids) {
		return llr.findAllById(ids);
	}

	@Override
	public long count() {
		return llr.count();
	}

	@Override
	public void deleteById(Integer id) {
		llr.deleteById(id);
	}

	@Override
	public void delete(llenadosRutaVO entity) {
		llr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends llenadosRutaVO> entities) {
		llr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		llr.deleteAll();
	}
	
	



}
