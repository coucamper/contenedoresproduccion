package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ClientesExportacionesVO;
import com.dawes.repository.ClientesExportacionesRepo;
import com.dawes.services.ClientesExportacionesService;

@Primary
@Service
public class ClientesExportacionesServiceImpl implements ClientesExportacionesRepo, ClientesExportacionesService {

	@Autowired
	ClientesExportacionesRepo cer;

	@Override
	public <S extends ClientesExportacionesVO> S save(S entity) {
		return cer.save(entity);
	}

	@Override
	public <S extends ClientesExportacionesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cer.saveAll(entities);
	}

	@Override
	public Optional<ClientesExportacionesVO> findById(Integer id) {
		return cer.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cer.existsById(id);
	}

	@Override
	public Iterable<ClientesExportacionesVO> findAll() {
		return cer.findAll();
	}

	@Override
	public Iterable<ClientesExportacionesVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(ClientesExportacionesVO entity) {
		cer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ClientesExportacionesVO> entities) {
		cer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cer.deleteAll();
	}
	
	
	
}
