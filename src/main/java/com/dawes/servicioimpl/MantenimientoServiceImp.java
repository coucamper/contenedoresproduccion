package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.MantenimientoVO;
import com.dawes.repository.MantenimientoRepo;
import com.dawes.services.MantenimientoService;

@Service
public class MantenimientoServiceImp implements MantenimientoRepo, MantenimientoService {

	@Autowired
	MantenimientoRepo mr;

	@Override
	public List<MantenimientoVO> BuscarMantenimientosVehiculo(int idvehiculo) {
		return mr.BuscarMantenimientosVehiculo(idvehiculo);
	}

	@Override
	public <S extends MantenimientoVO> S save(S entity) {
		return mr.save(entity);
	}

	@Override
	public <S extends MantenimientoVO> Optional<S> findOne(Example<S> example) {
		return mr.findOne(example);
	}

	@Override
	public Page<MantenimientoVO> findAll(Pageable pageable) {
		return mr.findAll(pageable);
	}

	@Override
	public List<MantenimientoVO> findAll() {
		return mr.findAll();
	}

	@Override
	public List<MantenimientoVO> findAll(Sort sort) {
		return mr.findAll(sort);
	}

	@Override
	public List<MantenimientoVO> findAllById(Iterable<Integer> ids) {
		return mr.findAllById(ids);
	}

	@Override
	public <S extends MantenimientoVO> List<S> saveAll(Iterable<S> entities) {
		return mr.saveAll(entities);
	}

	@Override
	public Optional<MantenimientoVO> findById(Integer id) {
		return mr.findById(id);
	}

	@Override
	public void flush() {
		mr.flush();
	}

	@Override
	public <S extends MantenimientoVO> S saveAndFlush(S entity) {
		return mr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return mr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<MantenimientoVO> entities) {
		mr.deleteInBatch(entities);
	}

	@Override
	public <S extends MantenimientoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return mr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		mr.deleteAllInBatch();
	}

	@Override
	public MantenimientoVO getOne(Integer id) {
		return mr.getOne(id);
	}

	@Override
	public <S extends MantenimientoVO> long count(Example<S> example) {
		return mr.count(example);
	}

	@Override
	public <S extends MantenimientoVO> boolean exists(Example<S> example) {
		return mr.exists(example);
	}

	@Override
	public <S extends MantenimientoVO> List<S> findAll(Example<S> example) {
		return mr.findAll(example);
	}

	@Override
	public long count() {
		return mr.count();
	}

	@Override
	public void deleteById(Integer id) {
		mr.deleteById(id);
	}

	@Override
	public <S extends MantenimientoVO> List<S> findAll(Example<S> example, Sort sort) {
		return mr.findAll(example, sort);
	}

	@Override
	public void delete(MantenimientoVO entity) {
		mr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MantenimientoVO> entities) {
		mr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mr.deleteAll();
	}

	
	
	
	

}
