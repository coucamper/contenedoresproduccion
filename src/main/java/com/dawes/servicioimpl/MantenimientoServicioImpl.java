package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.MantenimientoVO;
import com.dawes.repository.MantenimientoRepo;
import com.dawes.services.MantenimientoService;

@Service
public class MantenimientoServicioImpl implements MantenimientoRepo, MantenimientoService {

	@Autowired
	MantenimientoRepo mr;

	@Override
	public <S extends MantenimientoVO> S save(S entity) {
		return mr.save(entity);
	}

	@Override
	public <S extends MantenimientoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return mr.saveAll(entities);
	}

	@Override
	public Optional<MantenimientoVO> findById(Integer id) {
		return mr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return mr.existsById(id);
	}

	@Override
	public Iterable<MantenimientoVO> findAll() {
		return mr.findAll();
	}

	@Override
	public Iterable<MantenimientoVO> findAllById(Iterable<Integer> ids) {
		return mr.findAllById(ids);
	}

	@Override
	public long count() {
		return mr.count();
	}

	@Override
	public void deleteById(Integer id) {
		mr.deleteById(id);
	}

	@Override
	public void delete(MantenimientoVO entity) {
		mr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MantenimientoVO> entities) {
		mr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mr.deleteAll();
	}
	
	

}
