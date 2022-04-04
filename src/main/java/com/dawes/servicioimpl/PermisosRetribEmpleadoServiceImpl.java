package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PermisosRetribuidosEmpleadoVO;
import com.dawes.repository.PermisosRetribEmpleadoRepo;
import com.dawes.services.PermisosRetribEmpleadoService;

@Service
public class PermisosRetribEmpleadoServiceImpl implements PermisosRetribEmpleadoRepo, PermisosRetribEmpleadoService {

	@Autowired
	PermisosRetribEmpleadoRepo prer;

	@Override
	public <S extends PermisosRetribuidosEmpleadoVO> S save(S entity) {
		return prer.save(entity);
	}

	@Override
	public <S extends PermisosRetribuidosEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return prer.saveAll(entities);
	}

	@Override
	public Optional<PermisosRetribuidosEmpleadoVO> findById(Integer id) {
		return prer.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return prer.existsById(id);
	}

	@Override
	public Iterable<PermisosRetribuidosEmpleadoVO> findAll() {
		return prer.findAll();
	}

	@Override
	public Iterable<PermisosRetribuidosEmpleadoVO> findAllById(Iterable<Integer> ids) {
		return prer.findAllById(ids);
	}

	@Override
	public long count() {
		return prer.count();
	}

	@Override
	public void deleteById(Integer id) {
		prer.deleteById(id);
	}

	@Override
	public void delete(PermisosRetribuidosEmpleadoVO entity) {
		prer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PermisosRetribuidosEmpleadoVO> entities) {
		prer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		prer.deleteAll();
	}
	
	
}
