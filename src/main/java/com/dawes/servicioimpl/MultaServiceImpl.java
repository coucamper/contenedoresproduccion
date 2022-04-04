package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.MultaVO;
import com.dawes.repository.MultaRepo;
import com.dawes.services.MultaService;

@Service
public class MultaServiceImpl implements MultaRepo, MultaService {

	@Autowired
	MultaRepo mr;

	@Override
	public List<MultaVO> BuscarMultasPorVehiculo(int idvehiculo) {
		return mr.BuscarMultasPorVehiculo(idvehiculo);
	}

	@Override
	public <S extends MultaVO> S save(S entity) {
		return mr.save(entity);
	}

	@Override
	public <S extends MultaVO> Optional<S> findOne(Example<S> example) {
		return mr.findOne(example);
	}

	@Override
	public Page<MultaVO> findAll(Pageable pageable) {
		return mr.findAll(pageable);
	}

	@Override
	public List<MultaVO> findAll() {
		return mr.findAll();
	}

	@Override
	public List<MultaVO> findAll(Sort sort) {
		return mr.findAll(sort);
	}

	@Override
	public List<MultaVO> findAllById(Iterable<Integer> ids) {
		return mr.findAllById(ids);
	}

	@Override
	public <S extends MultaVO> List<S> saveAll(Iterable<S> entities) {
		return mr.saveAll(entities);
	}

	@Override
	public Optional<MultaVO> findById(Integer id) {
		return mr.findById(id);
	}

	@Override
	public void flush() {
		mr.flush();
	}

	@Override
	public <S extends MultaVO> S saveAndFlush(S entity) {
		return mr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return mr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<MultaVO> entities) {
		mr.deleteInBatch(entities);
	}

	@Override
	public <S extends MultaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return mr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		mr.deleteAllInBatch();
	}

	@Override
	public MultaVO getOne(Integer id) {
		return mr.getOne(id);
	}

	@Override
	public <S extends MultaVO> long count(Example<S> example) {
		return mr.count(example);
	}

	@Override
	public <S extends MultaVO> boolean exists(Example<S> example) {
		return mr.exists(example);
	}

	@Override
	public <S extends MultaVO> List<S> findAll(Example<S> example) {
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
	public <S extends MultaVO> List<S> findAll(Example<S> example, Sort sort) {
		return mr.findAll(example, sort);
	}

	@Override
	public void delete(MultaVO entity) {
		mr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MultaVO> entities) {
		mr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mr.deleteAll();
	}

	

	
	

}
