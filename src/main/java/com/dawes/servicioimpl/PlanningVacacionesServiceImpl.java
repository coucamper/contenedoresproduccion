package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PlanningVacacionesVO;
import com.dawes.repository.PlanningVacacionesRepo;
import com.dawes.services.PlanningVacacionesService;

@Service
public class PlanningVacacionesServiceImpl implements PlanningVacacionesRepo, PlanningVacacionesService {

	@Autowired
	PlanningVacacionesRepo pvr;

	@Override
	public List<PlanningVacacionesVO> BuscarVacacionesEmpleado(int idempleado) {
		return pvr.BuscarVacacionesEmpleado(idempleado);
	}

	@Override
	public <S extends PlanningVacacionesVO> S save(S entity) {
		return pvr.save(entity);
	}

	@Override
	public <S extends PlanningVacacionesVO> Optional<S> findOne(Example<S> example) {
		return pvr.findOne(example);
	}

	@Override
	public Page<PlanningVacacionesVO> findAll(Pageable pageable) {
		return pvr.findAll(pageable);
	}

	@Override
	public List<PlanningVacacionesVO> findAll() {
		return pvr.findAll();
	}

	@Override
	public List<PlanningVacacionesVO> findAll(Sort sort) {
		return pvr.findAll(sort);
	}

	@Override
	public List<PlanningVacacionesVO> findAllById(Iterable<Integer> ids) {
		return pvr.findAllById(ids);
	}

	@Override
	public <S extends PlanningVacacionesVO> List<S> saveAll(Iterable<S> entities) {
		return pvr.saveAll(entities);
	}

	@Override
	public Optional<PlanningVacacionesVO> findById(Integer id) {
		return pvr.findById(id);
	}

	@Override
	public void flush() {
		pvr.flush();
	}

	@Override
	public <S extends PlanningVacacionesVO> S saveAndFlush(S entity) {
		return pvr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return pvr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<PlanningVacacionesVO> entities) {
		pvr.deleteInBatch(entities);
	}

	@Override
	public <S extends PlanningVacacionesVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return pvr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		pvr.deleteAllInBatch();
	}

	@Override
	public PlanningVacacionesVO getOne(Integer id) {
		return pvr.getOne(id);
	}

	@Override
	public <S extends PlanningVacacionesVO> long count(Example<S> example) {
		return pvr.count(example);
	}

	@Override
	public <S extends PlanningVacacionesVO> boolean exists(Example<S> example) {
		return pvr.exists(example);
	}

	@Override
	public <S extends PlanningVacacionesVO> List<S> findAll(Example<S> example) {
		return pvr.findAll(example);
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
	public <S extends PlanningVacacionesVO> List<S> findAll(Example<S> example, Sort sort) {
		return pvr.findAll(example, sort);
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
