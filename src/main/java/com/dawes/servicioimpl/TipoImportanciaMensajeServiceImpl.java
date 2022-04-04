package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoImportanciaMensajeVO;
import com.dawes.repository.TipoImportanciaMensajeRepo;
import com.dawes.services.TipoImportanciaMensajeService;

@Service
public class TipoImportanciaMensajeServiceImpl implements TipoImportanciaMensajeRepo, TipoImportanciaMensajeService {

	@Autowired
	TipoImportanciaMensajeRepo timr;

	@Override
	public <S extends TipoImportanciaMensajeVO> S save(S entity) {
		return timr.save(entity);
	}

	@Override
	public <S extends TipoImportanciaMensajeVO> Iterable<S> saveAll(Iterable<S> entities) {
		return timr.saveAll(entities);
	}

	@Override
	public Optional<TipoImportanciaMensajeVO> findById(Integer id) {
		return timr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return timr.existsById(id);
	}

	@Override
	public Iterable<TipoImportanciaMensajeVO> findAll() {
		return timr.findAll();
	}

	@Override
	public Iterable<TipoImportanciaMensajeVO> findAllById(Iterable<Integer> ids) {
		return timr.findAllById(ids);
	}

	@Override
	public long count() {
		return timr.count();
	}

	@Override
	public void deleteById(Integer id) {
		timr.deleteById(id);
	}

	@Override
	public void delete(TipoImportanciaMensajeVO entity) {
		timr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoImportanciaMensajeVO> entities) {
		timr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		timr.deleteAll();
	}
	
	

}
