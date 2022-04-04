package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ComarcasRutaVO;
import com.dawes.repository.ComarcasRutaRepo;
import com.dawes.services.ComarcasRutaService;

@Service
public class ComarcasRutaServiceImpl implements ComarcasRutaRepo, ComarcasRutaService {

	@Autowired
	ComarcasRutaRepo crr;

	@Override
	public <S extends ComarcasRutaVO> S save(S entity) {
		return crr.save(entity);
	}

	@Override
	public <S extends ComarcasRutaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return crr.saveAll(entities);
	}

	@Override
	public Optional<ComarcasRutaVO> findById(Integer id) {
		return crr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return crr.existsById(id);
	}

	@Override
	public Iterable<ComarcasRutaVO> findAll() {
		return crr.findAll();
	}

	@Override
	public Iterable<ComarcasRutaVO> findAllById(Iterable<Integer> ids) {
		return crr.findAllById(ids);
	}

	@Override
	public long count() {
		return crr.count();
	}

	@Override
	public void deleteById(Integer id) {
		crr.deleteById(id);
	}

	@Override
	public void delete(ComarcasRutaVO entity) {
		crr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ComarcasRutaVO> entities) {
		crr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		crr.deleteAll();
	}
	
	
}
