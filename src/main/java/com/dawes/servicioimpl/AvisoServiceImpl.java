package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.AvisoVO;
import com.dawes.repository.AvisoRepo;
import com.dawes.services.AvisoService;


@Service
public class AvisoServiceImpl implements AvisoRepo, AvisoService {

	@Autowired
	AvisoRepo ar;

	@Override
	public <S extends AvisoVO> S save(S entity) {
		return ar.save(entity);
	}

	@Override
	public <S extends AvisoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ar.saveAll(entities);
	}

	@Override
	public Optional<AvisoVO> findById(Integer id) {
		return ar.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ar.existsById(id);
	}

	@Override
	public Iterable<AvisoVO> findAll() {
		return ar.findAll();
	}

	@Override
	public Iterable<AvisoVO> findAllById(Iterable<Integer> ids) {
		return ar.findAllById(ids);
	}

	@Override
	public long count() {
		return ar.count();
	}

	@Override
	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

	@Override
	public void delete(AvisoVO entity) {
		ar.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends AvisoVO> entities) {
		ar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ar.deleteAll();
	}
	
	
	
}
