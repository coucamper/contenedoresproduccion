package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ClaseExportacionesVO;
import com.dawes.repository.ClaseExportacionesRepo;
import com.dawes.services.ClaseExportacionesService;

@Primary
@Service
public class ClaseExportacionesServiceImpl implements ClaseExportacionesRepo, ClaseExportacionesService {

	@Autowired
	ClaseExportacionesRepo cer;

	@Override
	public <S extends ClaseExportacionesVO> S save(S entity) {
		return cer.save(entity);
	}

	@Override
	public <S extends ClaseExportacionesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cer.saveAll(entities);
	}

	@Override
	public Optional<ClaseExportacionesVO> findById(Integer id) {
		return cer.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cer.existsById(id);
	}

	@Override
	public Iterable<ClaseExportacionesVO> findAll() {
		return cer.findAll();
	}

	@Override
	public Iterable<ClaseExportacionesVO> findAllById(Iterable<Integer> ids) {
		return cer.findAllById(ids);
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
	public void delete(ClaseExportacionesVO entity) {
		cer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ClaseExportacionesVO> entities) {
		cer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cer.deleteAll();
	}
	
	
	
}
