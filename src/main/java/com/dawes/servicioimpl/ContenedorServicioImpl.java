package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ContenedorVO;
import com.dawes.repository.ContenedorRepo;
import com.dawes.services.ContenedorService;

@Primary
@Service
public class ContenedorServicioImpl implements ContenedorRepo, ContenedorService {
	
	@Autowired
	ContenedorRepo cr;

	@Override
	public <S extends ContenedorVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ContenedorVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ContenedorVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<ContenedorVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<ContenedorVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(ContenedorVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ContenedorVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}

	

}
