package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.UsuarioRolVO;
import com.dawes.repository.UsuarioRolRepo;
import com.dawes.services.UsuarioRolService;

@Primary
@Service
public class UsuarioRolServiceImpl implements UsuarioRolRepo, UsuarioRolService {

	@Autowired
	UsuarioRolRepo urr;

	@Override
	public <S extends UsuarioRolVO> S save(S entity) {
		return urr.save(entity);
	}

	@Override
	public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return urr.saveAll(entities);
	}

	@Override
	public Optional<UsuarioRolVO> findById(Integer id) {
		return urr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return urr.existsById(id);
	}

	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return urr.findAll();
	}

	@Override
	public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
		return urr.findAllById(ids);
	}

	@Override
	public long count() {
		return urr.count();
	}

	@Override
	public void deleteById(Integer id) {
		urr.deleteById(id);
	}

	@Override
	public void delete(UsuarioRolVO entity) {
		urr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
		urr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		urr.deleteAll();
	}
	
	

}
