package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PlanningVacacionesVO;
import com.dawes.repository.PlanningVacacionesRepo;
import com.dawes.services.PlanningVacacionesService;

@Service
public class PlanningVacacionesServiceImpl implements PlanningVacacionesRepo, PlanningVacacionesService {

	@Autowired
	PlanningVacacionesRepo pvr;

	@Override
	public <S extends PlanningVacacionesVO> S save(S entity) {
		return pvr.save(entity);
	}

	@Override
	public <S extends PlanningVacacionesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return pvr.saveAll(entities);
	}

	@Override
	public Optional<PlanningVacacionesVO> findById(Integer id) {
		return pvr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return pvr.existsById(id);
	}

	@Override
	public Iterable<PlanningVacacionesVO> findAll() {
		return pvr.findAll();
	}

	@Override
	public Iterable<PlanningVacacionesVO> findAllById(Iterable<Integer> ids) {
		return pvr.findAllById(ids);
	}

	@Override
	public long count() {
		return pvr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pvr.deleteById(id);
	}

	@Override
	public void delete(PlanningVacacionesVO entity) {
		pvr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PlanningVacacionesVO> entities) {
		pvr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pvr.deleteAll();
	}
	
	
}
