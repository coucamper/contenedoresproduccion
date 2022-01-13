package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoPermisoNrVO;
import com.dawes.repository.TipoPermisoNrRepo;
import com.dawes.services.TipoPermisoNrService;

@Service
public class TipoPermisoNrServiceImpl implements TipoPermisoNrRepo, TipoPermisoNrService {
	
	@Autowired
	TipoPermisoNrRepo pnrr;

	@Override
	public <S extends TipoPermisoNrVO> S save(S entity) {
		return pnrr.save(entity);
	}

	@Override
	public <S extends TipoPermisoNrVO> Iterable<S> saveAll(Iterable<S> entities) {
		return pnrr.saveAll(entities);
	}

	@Override
	public Optional<TipoPermisoNrVO> findById(Integer id) {
		return pnrr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return pnrr.existsById(id);
	}

	@Override
	public Iterable<TipoPermisoNrVO> findAll() {
		return pnrr.findAll();
	}

	@Override
	public Iterable<TipoPermisoNrVO> findAllById(Iterable<Integer> ids) {
		return pnrr.findAllById(ids);
	}

	@Override
	public long count() {
		return pnrr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pnrr.deleteById(id);
	}

	@Override
	public void delete(TipoPermisoNrVO entity) {
		pnrr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoPermisoNrVO> entities) {
		pnrr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pnrr.deleteAll();
	}
	
	


}
