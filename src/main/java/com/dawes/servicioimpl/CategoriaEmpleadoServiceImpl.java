package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.CategoriaEmpleadoVO;
import com.dawes.repository.CategoriaEmpleadoRepo;
import com.dawes.services.CategoriaEmpleadoService;

@Service
public class CategoriaEmpleadoServiceImpl implements CategoriaEmpleadoRepo, CategoriaEmpleadoService {

	@Autowired
	CategoriaEmpleadoRepo cer;

	@Override
	public <S extends CategoriaEmpleadoVO> S save(S entity) {
		return cer.save(entity);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> Optional<S> findOne(Example<S> example) {
		return cer.findOne(example);
	}

	@Override
	public Page<CategoriaEmpleadoVO> findAll(Pageable pageable) {
		return cer.findAll(pageable);
	}

	@Override
	public List<CategoriaEmpleadoVO> findAll() {
		return cer.findAll();
	}

	@Override
	public List<CategoriaEmpleadoVO> findAll(Sort sort) {
		return cer.findAll(sort);
	}

	@Override
	public List<CategoriaEmpleadoVO> findAllById(Iterable<Integer> ids) {
		return cer.findAllById(ids);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> List<S> saveAll(Iterable<S> entities) {
		return cer.saveAll(entities);
	}

	@Override
	public Optional<CategoriaEmpleadoVO> findById(Integer id) {
		return cer.findById(id);
	}

	@Override
	public void flush() {
		cer.flush();
	}

	@Override
	public <S extends CategoriaEmpleadoVO> S saveAndFlush(S entity) {
		return cer.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return cer.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<CategoriaEmpleadoVO> entities) {
		cer.deleteInBatch(entities);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cer.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		cer.deleteAllInBatch();
	}

	@Override
	public CategoriaEmpleadoVO getOne(Integer id) {
		return cer.getOne(id);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> long count(Example<S> example) {
		return cer.count(example);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> boolean exists(Example<S> example) {
		return cer.exists(example);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> List<S> findAll(Example<S> example) {
		return cer.findAll(example);
	}

	@Override
	public long count() {
		return cer.count();
	}

	@Override
	public void deleteById(Integer id) {
		cer.deleteById(id);
	}

	@Override
	public <S extends CategoriaEmpleadoVO> List<S> findAll(Example<S> example, Sort sort) {
		return cer.findAll(example, sort);
	}

	@Override
	public void delete(CategoriaEmpleadoVO entity) {
		cer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends CategoriaEmpleadoVO> entities) {
		cer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cer.deleteAll();
	}


	

}
