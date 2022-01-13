package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.VehiculoVO;
import com.dawes.repository.VehiculoRepo;
import com.dawes.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoRepo, VehiculoService {

	@Autowired
	VehiculoRepo vr;

	@Override
	public <S extends VehiculoVO> S save(S entity) {
		return vr.save(entity);
	}

	@Override
	public <S extends VehiculoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return vr.saveAll(entities);
	}

	@Override
	public Optional<VehiculoVO> findById(Integer id) {
		return vr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return vr.existsById(id);
	}

	@Override
	public Iterable<VehiculoVO> findAll() {
		return vr.findAll();
	}

	@Override
	public Iterable<VehiculoVO> findAllById(Iterable<Integer> ids) {
		return vr.findAllById(ids);
	}

	@Override
	public long count() {
		return vr.count();
	}

	@Override
	public void deleteById(Integer id) {
		vr.deleteById(id);
	}

	@Override
	public void delete(VehiculoVO entity) {
		vr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends VehiculoVO> entities) {
		vr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		vr.deleteAll();
	}
	
	


}
