package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.llenadoContVO;
import com.dawes.repository.LlenadoContRepo;
import com.dawes.services.LlenadoContService;

@Service
public class LlenadoContServiceImpl implements LlenadoContRepo, LlenadoContService {

	@Autowired
	LlenadoContRepo lcr;

	@Override
	public <S extends llenadoContVO> S save(S entity) {
		return lcr.save(entity);
	}

	@Override
	public <S extends llenadoContVO> Iterable<S> saveAll(Iterable<S> entities) {
		return lcr.saveAll(entities);
	}

	@Override
	public Optional<llenadoContVO> findById(Integer id) {
		return lcr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lcr.existsById(id);
	}

	@Override
	public Iterable<llenadoContVO> findAll() {
		return lcr.findAll();
	}

	@Override
	public Iterable<llenadoContVO> findAllById(Iterable<Integer> ids) {
		return lcr.findAllById(ids);
	}

	@Override
	public long count() {
		return lcr.count();
	}

	@Override
	public void deleteById(Integer id) {
		lcr.deleteById(id);
	}

	@Override
	public void delete(llenadoContVO entity) {
		lcr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends llenadoContVO> entities) {
		lcr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lcr.deleteAll();
	}
	
	

}
