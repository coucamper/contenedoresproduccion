package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.repository.EmpleadoRepo;
import com.dawes.services.EmpleadoService;

@Primary
@Service
public class EmpleadoServiceImpl implements EmpleadoRepo, EmpleadoService {
	
	@Autowired
	EmpleadoRepo er;

	@Override
	public <S extends EmpleadoVO> S save(S entity) {
		return er.save(entity);
	}

	@Override
	public <S extends EmpleadoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return er.saveAll(entities);
	}

	@Override
	public Optional<EmpleadoVO> findById(Integer id) {
		return er.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return er.existsById(id);
	}

	@Override
	public Iterable<EmpleadoVO> findAll() {
		return er.findAll();
	}

	@Override
	public Iterable<EmpleadoVO> findAllById(Iterable<Integer> ids) {
		return er.findAllById(ids);
	}

	@Override
	public long count() {
		return er.count();
	}

	@Override
	public void deleteById(Integer id) {
		er.deleteById(id);
	}

	@Override
	public void delete(EmpleadoVO entity) {
		er.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends EmpleadoVO> entities) {
		er.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}
	
	

}
