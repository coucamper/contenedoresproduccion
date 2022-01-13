package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.RevisionesVehiculoVO;
import com.dawes.repository.RevisionesVehiculoRepo;
import com.dawes.services.RevisionesVehiculoService;



@Service
public class RevisionesVehiculoServiceImpl implements RevisionesVehiculoRepo, RevisionesVehiculoService {
	
	@Autowired
	RevisionesVehiculoRepo rvr;

	@Override
	public <S extends RevisionesVehiculoVO> S save(S entity) {
		return rvr.save(entity);
	}

	@Override
	public <S extends RevisionesVehiculoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rvr.saveAll(entities);
	}

	@Override
	public Optional<RevisionesVehiculoVO> findById(Integer id) {
		return rvr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rvr.existsById(id);
	}

	@Override
	public Iterable<RevisionesVehiculoVO> findAll() {
		return rvr.findAll();
	}

	@Override
	public Iterable<RevisionesVehiculoVO> findAllById(Iterable<Integer> ids) {
		return rvr.findAllById(ids);
	}

	@Override
	public long count() {
		return rvr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rvr.deleteById(id);
	}

	@Override
	public void delete(RevisionesVehiculoVO entity) {
		rvr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RevisionesVehiculoVO> entities) {
		rvr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rvr.deleteAll();
	}
	
	


}
