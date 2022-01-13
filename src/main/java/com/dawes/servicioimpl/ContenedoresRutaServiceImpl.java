package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.repository.ContenedoresRutasRepo;
import com.dawes.services.ContenedoresRutaService;

@Primary
@Service
public class ContenedoresRutaServiceImpl implements ContenedoresRutasRepo, ContenedoresRutaService {

	@Autowired
	ContenedoresRutasRepo crr;

	@Override
	public List<ContenedoresRutasVO> BuscarContenedoresRuta(int idruta) {
		return crr.BuscarContenedoresRuta(idruta);
	}

	@Override
	public <S extends ContenedoresRutasVO> S save(S entity) {
		return crr.save(entity);
	}

	@Override
	public <S extends ContenedoresRutasVO> Iterable<S> saveAll(Iterable<S> entities) {
		return crr.saveAll(entities);
	}

	@Override
	public Optional<ContenedoresRutasVO> findById(Integer id) {
		return crr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return crr.existsById(id);
	}

	@Override
	public Iterable<ContenedoresRutasVO> findAll() {
		return crr.findAll();
	}

	@Override
	public Iterable<ContenedoresRutasVO> findAllById(Iterable<Integer> ids) {
		return crr.findAllById(ids);
	}

	@Override
	public long count() {
		return crr.count();
	}

	@Override
	public void deleteById(Integer id) {
		crr.deleteById(id);
	}

	@Override
	public void delete(ContenedoresRutasVO entity) {
		crr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ContenedoresRutasVO> entities) {
		crr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		crr.deleteAll();
	}
	
	

}
