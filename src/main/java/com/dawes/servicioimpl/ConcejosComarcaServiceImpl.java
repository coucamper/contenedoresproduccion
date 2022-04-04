package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ConcejosComarcaVO;
import com.dawes.repository.ConcejosComarcaRepo;
import com.dawes.services.ConcejosComarcaService;


@Service
public class ConcejosComarcaServiceImpl implements ConcejosComarcaRepo, ConcejosComarcaService {

	@Autowired
	ConcejosComarcaRepo ccr;

	@Override
	public <S extends ConcejosComarcaVO> S save(S entity) {
		return ccr.save(entity);
	}

	@Override
	public <S extends ConcejosComarcaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ccr.saveAll(entities);
	}

	@Override
	public Optional<ConcejosComarcaVO> findById(Integer id) {
		return ccr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ccr.existsById(id);
	}

	@Override
	public Iterable<ConcejosComarcaVO> findAll() {
		return ccr.findAll();
	}

	@Override
	public Iterable<ConcejosComarcaVO> findAllById(Iterable<Integer> ids) {
		return ccr.findAllById(ids);
	}

	@Override
	public long count() {
		return ccr.count();
	}

	@Override
	public void deleteById(Integer id) {
		ccr.deleteById(id);
	}

	@Override
	public void delete(ConcejosComarcaVO entity) {
		ccr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ConcejosComarcaVO> entities) {
		ccr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ccr.deleteAll();
	}

	@Override
	public List<ConcejosComarcaVO> ConcejosPorComarca(int idcomarca) {
		return ccr.ConcejosPorComarca(idcomarca);
	}
	
	
}
