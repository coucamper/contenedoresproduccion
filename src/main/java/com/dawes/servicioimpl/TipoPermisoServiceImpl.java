package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TipoPermisoVO;
import com.dawes.repository.TipoPermisoRepo;
import com.dawes.services.TipoPermisoService;

@Service
public class TipoPermisoServiceImpl implements TipoPermisoRepo, TipoPermisoService {
	
	@Autowired
	TipoPermisoRepo tpr;

	@Override
	public <S extends TipoPermisoVO> S save(S entity) {
		return tpr.save(entity);
	}

	@Override
	public <S extends TipoPermisoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return tpr.saveAll(entities);
	}

	@Override
	public Optional<TipoPermisoVO> findById(Integer id) {
		return tpr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return tpr.existsById(id);
	}

	@Override
	public Iterable<TipoPermisoVO> findAll() {
		return tpr.findAll();
	}

	@Override
	public Iterable<TipoPermisoVO> findAllById(Iterable<Integer> ids) {
		return tpr.findAllById(ids);
	}

	@Override
	public long count() {
		return tpr.count();
	}

	@Override
	public void deleteById(Integer id) {
		tpr.deleteById(id);
	}

	@Override
	public void delete(TipoPermisoVO entity) {
		tpr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TipoPermisoVO> entities) {
		tpr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tpr.deleteAll();
	}
	
	

	

}
