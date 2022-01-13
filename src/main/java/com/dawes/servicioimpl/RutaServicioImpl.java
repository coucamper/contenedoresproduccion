package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.RutaVO;
import com.dawes.repository.RutaRepo;
import com.dawes.services.RutaService;

@Primary
@Service
public class RutaServicioImpl implements RutaRepo, RutaService {

	@Autowired
	RutaRepo rr;

	@Override
	public <S extends RutaVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RutaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RutaVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public Iterable<RutaVO> findAll() {
		return rr.findAll();
	}

	@Override
	public Iterable<RutaVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
	}

	@Override
	public long count() {
		return rr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	@Override
	public void delete(RutaVO entity) {
		rr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RutaVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}

	public List<ContenedoresRutasVO> buscarContenedoresRuta(int idruta) {
		return rr.buscarContenedoresRuta(idruta);
	}
	
	
}
