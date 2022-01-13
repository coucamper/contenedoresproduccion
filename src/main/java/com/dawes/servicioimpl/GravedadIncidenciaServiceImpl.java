package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.GravedadIncidenciaVO;
import com.dawes.repository.GravedadIncidenciaRepo;
import com.dawes.services.GravedadIncidenciaService;

@Primary
@Service
public class GravedadIncidenciaServiceImpl implements GravedadIncidenciaRepo, GravedadIncidenciaService {

	@Autowired
	GravedadIncidenciaRepo gir;

	@Override
	public <S extends GravedadIncidenciaVO> S save(S entity) {
		return gir.save(entity);
	}

	@Override
	public <S extends GravedadIncidenciaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return gir.saveAll(entities);
	}

	@Override
	public Optional<GravedadIncidenciaVO> findById(Integer id) {
		return gir.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return gir.existsById(id);
	}

	@Override
	public Iterable<GravedadIncidenciaVO> findAll() {
		return gir.findAll();
	}

	@Override
	public Iterable<GravedadIncidenciaVO> findAllById(Iterable<Integer> ids) {
		return gir.findAllById(ids);
	}

	@Override
	public long count() {
		return gir.count();
	}

	@Override
	public void deleteById(Integer id) {
		gir.deleteById(id);
	}

	@Override
	public void delete(GravedadIncidenciaVO entity) {
		gir.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends GravedadIncidenciaVO> entities) {
		gir.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		gir.deleteAll();
	}
	
	
}
