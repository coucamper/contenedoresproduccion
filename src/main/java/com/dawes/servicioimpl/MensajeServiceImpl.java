package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.MensajeVO;
import com.dawes.repository.MensajeRepo;
import com.dawes.services.MensajeService;

@Primary
@Service
public class MensajeServiceImpl implements MensajeRepo, MensajeService {

	@Autowired
	MensajeRepo mr;

	@Override
	public <S extends MensajeVO> S save(S entity) {
		return mr.save(entity);
	}

	@Override
	public <S extends MensajeVO> Iterable<S> saveAll(Iterable<S> entities) {
		return mr.saveAll(entities);
	}

	@Override
	public Optional<MensajeVO> findById(Integer id) {
		return mr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return mr.existsById(id);
	}

	@Override
	public Iterable<MensajeVO> findAll() {
		return mr.findAll();
	}

	@Override
	public Iterable<MensajeVO> findAllById(Iterable<Integer> ids) {
		return mr.findAllById(ids);
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
	public void delete(MensajeVO entity) {
		mr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MensajeVO> entities) {
		mr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mr.deleteAll();
	}
	
	
}
