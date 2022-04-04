package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoMantenimientoVO;
import com.dawes.repository.TipoMantenimientoRepo;
import com.dawes.services.TipoMantenimientoService;

@Service
public class TipoMantenimientoServiceImpl implements TipoMantenimientoRepo, TipoMantenimientoService {

	@Autowired
	TipoMantenimientoRepo tmr;

	@Override
	public <S extends TipoMantenimientoVO> S save(S entity) {
		return tmr.save(entity);
	}

	@Override
	public <S extends TipoMantenimientoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tmr.saveAll(entities);
	}

	@Override
	public Optional<TipoMantenimientoVO> findById(Integer id) {
		return tmr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tmr.existsById(id);
	}

	@Override
	public Iterable<TipoMantenimientoVO> findAll() {
		return tmr.findAll();
	}

	@Override
	public Iterable<TipoMantenimientoVO> findAllById(Iterable<Integer> ids) {
		return tmr.findAllById(ids);
	}

	@Override
	public long count() {
		return tmr.count();
	}

	@Override
	public void deleteById(Integer id) {
		tmr.deleteById(id);
	}

	@Override
	public void delete(TipoMantenimientoVO entity) {
		tmr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoMantenimientoVO> entities) {
		tmr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tmr.deleteAll();
	}
	
	
}
