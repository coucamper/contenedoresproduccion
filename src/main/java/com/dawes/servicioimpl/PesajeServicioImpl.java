package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.PesajeVO;
import com.dawes.repository.PesajeRepo;
import com.dawes.services.PesajeService;


@Primary
@Service
public class PesajeServicioImpl implements PesajeRepo, PesajeService {
	
	@Autowired
	PesajeRepo pr;

	@Override
	public <S extends PesajeVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends PesajeVO> Iterable<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public Optional<PesajeVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public Iterable<PesajeVO> findAll() {
		return pr.findAll();
	}

	@Override
	public Iterable<PesajeVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public void delete(PesajeVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PesajeVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}

	@Override
	public Long sumPesajes() {
		return pr.sumPesajes();
	}
	
	
	

}
