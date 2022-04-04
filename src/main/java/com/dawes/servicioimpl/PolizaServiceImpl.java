package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PolizaVO;
import com.dawes.repository.PolizaRepo;
import com.dawes.services.PolizaService;


@Service
public class PolizaServiceImpl implements PolizaRepo, PolizaService {

	@Autowired
	PolizaRepo pr;

	@Override
	public Optional<PolizaVO> BuscarPolizaPorIdVehiculo(int idvehiculo) {
		return pr.BuscarPolizaPorIdVehiculo(idvehiculo);
	}

	@Override
	public <S extends PolizaVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends PolizaVO> Optional<S> findOne(Example<S> example) {
		return pr.findOne(example);
	}

	@Override
	public Page<PolizaVO> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}

	@Override
	public List<PolizaVO> findAll() {
		return pr.findAll();
	}

	@Override
	public List<PolizaVO> findAll(Sort sort) {
		return pr.findAll(sort);
	}

	@Override
	public List<PolizaVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public <S extends PolizaVO> List<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public Optional<PolizaVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public void flush() {
		pr.flush();
	}

	@Override
	public <S extends PolizaVO> S saveAndFlush(S entity) {
		return pr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<PolizaVO> entities) {
		pr.deleteInBatch(entities);
	}

	@Override
	public <S extends PolizaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return pr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		pr.deleteAllInBatch();
	}

	@Override
	public PolizaVO getOne(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public <S extends PolizaVO> long count(Example<S> example) {
		return pr.count(example);
	}

	@Override
	public <S extends PolizaVO> boolean exists(Example<S> example) {
		return pr.exists(example);
	}

	@Override
	public <S extends PolizaVO> List<S> findAll(Example<S> example) {
		return pr.findAll(example);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public <S extends PolizaVO> List<S> findAll(Example<S> example, Sort sort) {
		return pr.findAll(example, sort);
	}

	@Override
	public void delete(PolizaVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PolizaVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}

	
	
	

}
