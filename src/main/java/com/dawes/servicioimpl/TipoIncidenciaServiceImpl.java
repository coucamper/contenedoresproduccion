package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoIncidenciaVO;
import com.dawes.repository.TipoIncidenciaRepo;
import com.dawes.services.TipoIncidenciaService;

@Service
public class TipoIncidenciaServiceImpl implements TipoIncidenciaRepo, TipoIncidenciaService {

	@Autowired
	TipoIncidenciaRepo tir;

	@Override
	public <S extends TipoIncidenciaVO> S save(S entity) {
		return tir.save(entity);
	}

	@Override
	public <S extends TipoIncidenciaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tir.saveAll(entities);
	}

	@Override
	public Optional<TipoIncidenciaVO> findById(Integer id) {
		return tir.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tir.existsById(id);
	}

	@Override
	public Iterable<TipoIncidenciaVO> findAll() {
		return tir.findAll();
	}

	@Override
	public Iterable<TipoIncidenciaVO> findAllById(Iterable<Integer> ids) {
		return tir.findAllById(ids);
	}

	@Override
	public long count() {
		return tir.count();
	}

	@Override
	public void deleteById(Integer id) {
		tir.deleteById(id);
	}

	@Override
	public void delete(TipoIncidenciaVO entity) {
		tir.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoIncidenciaVO> entities) {
		tir.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tir.deleteAll();
	}
	
	

}
