package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.LlenadoContVO;
import com.dawes.repository.LlenadoContRepo;
import com.dawes.services.LlenadoContService;

@Service
public class LlenadoContendorServiceImpl implements LlenadoContRepo, LlenadoContService {

	@Autowired
	LlenadoContRepo lcr;

	@Override
	public <S extends LlenadoContVO> S save(S entity) {
		return lcr.save(entity);
	}

	@Override
	public <S extends LlenadoContVO> Iterable<S> saveAll(Iterable<S> entities) {
		return lcr.saveAll(entities);
	}

	@Override
	public Optional<LlenadoContVO> findById(Integer id) {
		return lcr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lcr.existsById(id);
	}

	@Override
	public Iterable<LlenadoContVO> findAll() {
		return lcr.findAll();
	}

	@Override
	public Iterable<LlenadoContVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(LlenadoContVO entity) {
		lcr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends LlenadoContVO> entities) {
		lcr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lcr.deleteAll();
	}
	
	
	

}
