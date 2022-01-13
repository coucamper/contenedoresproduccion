package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.CategoriaVO;
import com.dawes.repository.CategoriaRepo;
import com.dawes.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaRepo, CategoriaService {

	@Autowired
	CategoriaRepo cr;

	@Override
	public <S extends CategoriaVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends CategoriaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<CategoriaVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<CategoriaVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<CategoriaVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(CategoriaVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends CategoriaVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	
	

}
