package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PermisosNoRetribEmpleadoVO;
import com.dawes.repository.PermisosNoRetribEmpleadoRepo;
import com.dawes.services.PermisosNoRetribEmpleadoService;

@Service
public class PermisosNoRetribEmpleadoServiceImpl implements PermisosNoRetribEmpleadoRepo, PermisosNoRetribEmpleadoService {

	@Autowired
	PermisosNoRetribEmpleadoRepo pnrer;

	@Override
	public <S extends PermisosNoRetribEmpleadoVO> S save(S entity) {
		return pnrer.save(entity);
	}

	@Override
	public <S extends PermisosNoRetribEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return pnrer.saveAll(entities);
	}

	@Override
	public Optional<PermisosNoRetribEmpleadoVO> findById(Integer id) {
		return pnrer.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return pnrer.existsById(id);
	}

	@Override
	public Iterable<PermisosNoRetribEmpleadoVO> findAll() {
		return pnrer.findAll();
	}

	@Override
	public Iterable<PermisosNoRetribEmpleadoVO> findAllById(Iterable<Integer> ids) {
		return pnrer.findAllById(ids);
	}

	@Override
	public long count() {
		return pnrer.count();
	}

	@Override
	public void deleteById(Integer id) {
		pnrer.deleteById(id);
	}

	@Override
	public void delete(PermisosNoRetribEmpleadoVO entity) {
		pnrer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PermisosNoRetribEmpleadoVO> entities) {
		pnrer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pnrer.deleteAll();
	}
	
	

}
