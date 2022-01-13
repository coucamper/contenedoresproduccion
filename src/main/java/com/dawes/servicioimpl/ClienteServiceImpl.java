package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ClienteVO;
import com.dawes.repository.ClienteRepo;
import com.dawes.services.ClienteService;

@Primary
@Service
public class ClienteServiceImpl implements ClienteRepo, ClienteService {

	@Autowired
	ClienteRepo cr;

	@Override
	public <S extends ClienteVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ClienteVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ClienteVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<ClienteVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<ClienteVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(ClienteVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ClienteVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}
	
	

}
