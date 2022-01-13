package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ClaseVO;
import com.dawes.repository.ClaseRepo;
import com.dawes.services.ClaseService;

@Primary
@Service
public class ClaseServicioImpl implements ClaseRepo, ClaseService {

	@Autowired
	ClaseRepo cs;

	@Override
	public <S extends ClaseVO> S save(S entity) {
		return cs.save(entity);
	}

	@Override
	public <S extends ClaseVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cs.saveAll(entities);
	}

	@Override
	public Optional<ClaseVO> findById(Integer id) {
		return cs.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cs.existsById(id);
	}

	@Override
	public Iterable<ClaseVO> findAll() {
		return cs.findAll();
	}

	@Override
	public Iterable<ClaseVO> findAllById(Iterable<Integer> ids) {
		return cs.findAllById(ids);
	}

	@Override
	public long count() {
		return cs.count();
	}

	@Override
	public void deleteById(Integer id) {
		cs.deleteById(id);
	}

	@Override
	public void delete(ClaseVO entity) {
		cs.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ClaseVO> entities) {
		cs.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cs.deleteAll();
	}
	
	

}
