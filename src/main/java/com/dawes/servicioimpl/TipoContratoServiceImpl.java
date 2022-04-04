package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoContratoVO;
import com.dawes.repository.TipoContratoRepo;
import com.dawes.services.TipoContratoService;

@Service
public class TipoContratoServiceImpl implements TipoContratoRepo, TipoContratoService {

	@Autowired
	TipoContratoRepo tcr;

	@Override
	public <S extends TipoContratoVO> S save(S entity) {
		return tcr.save(entity);
	}

	@Override
	public <S extends TipoContratoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tcr.saveAll(entities);
	}

	@Override
	public Optional<TipoContratoVO> findById(Integer id) {
		return tcr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tcr.existsById(id);
	}

	@Override
	public Iterable<TipoContratoVO> findAll() {
		return tcr.findAll();
	}

	@Override
	public Iterable<TipoContratoVO> findAllById(Iterable<Integer> ids) {
		return tcr.findAllById(ids);
	}

	@Override
	public long count() {
		return tcr.count();
	}

	@Override
	public void deleteById(Integer id) {
		tcr.deleteById(id);
	}

	@Override
	public void delete(TipoContratoVO entity) {
		tcr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoContratoVO> entities) {
		tcr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tcr.deleteAll();
	}
	
	
	

}
