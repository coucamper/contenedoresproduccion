package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.AveriasVO;
import com.dawes.repository.AveriasRepo;
import com.dawes.services.AveriasService;

@Service
public class AveriasServiceImpl implements AveriasRepo, AveriasService {

	@Autowired
	AveriasRepo ar;

	@Override
	public <S extends AveriasVO> S save(S entity) {
		return ar.save(entity);
	}

	@Override
	public <S extends AveriasVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ar.saveAll(entities);
	}

	@Override
	public Optional<AveriasVO> findById(Integer id) {
		return ar.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ar.existsById(id);
	}

	@Override
	public Iterable<AveriasVO> findAll() {
		return ar.findAll();
	}

	@Override
	public Iterable<AveriasVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(AveriasVO entity) {
		ar.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends AveriasVO> entities) {
		ar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ar.deleteAll();
	}


	
}
