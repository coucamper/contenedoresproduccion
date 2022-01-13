package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.IncidenciaVO;
import com.dawes.repository.IncidenciaRepo;
import com.dawes.services.IncidenciaService;

@Primary
@Service
public class IncidenciaServiceImpl implements IncidenciaRepo, IncidenciaService {

	@Autowired
	IncidenciaRepo ir;

	@Override
	public <S extends IncidenciaVO> S save(S entity) {
		return ir.save(entity);
	}

	@Override
	public <S extends IncidenciaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ir.saveAll(entities);
	}

	@Override
	public Optional<IncidenciaVO> findById(Integer id) {
		return ir.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ir.existsById(id);
	}

	@Override
	public Iterable<IncidenciaVO> findAll() {
		return ir.findAll();
	}

	@Override
	public Iterable<IncidenciaVO> findAllById(Iterable<Integer> ids) {
		return ir.findAllById(ids);
	}

	@Override
	public long count() {
		return ir.count();
	}

	@Override
	public void deleteById(Integer id) {
		ir.deleteById(id);
	}

	@Override
	public void delete(IncidenciaVO entity) {
		ir.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends IncidenciaVO> entities) {
		ir.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ir.deleteAll();
	}
	
	
	
}
