package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.NivelesContenedoresVO;
import com.dawes.repository.NivelesContenedoresRepo;
import com.dawes.services.NivelesContenedoresRutaServices;


@Service
public class NIvelesContenedoresServiceImpl implements NivelesContenedoresRepo, NivelesContenedoresRutaServices {

	@Autowired
	NivelesContenedoresRepo ncr;

	@Override
	public List<NivelesContenedoresVO> NivelesContenedoresPorRuta(int idpesaje) {
		return ncr.NivelesContenedoresPorRuta(idpesaje);
	}

	@Override
	public List<NivelesContenedoresVO> NivelesContenedoresPorRuta2(int idpesaje, Pageable pageable) {
		return ncr.NivelesContenedoresPorRuta2(idpesaje, pageable);
	}

	@Override
	public List<NivelesContenedoresVO> NivelesContenedoresPorIdnivelcontenedor(int idnivelcontenedor) {
		return ncr.NivelesContenedoresPorIdnivelcontenedor(idnivelcontenedor);
	}

	@Override
	public <S extends NivelesContenedoresVO> S save(S entity) {
		return ncr.save(entity);
	}

	@Override
	public <S extends NivelesContenedoresVO> Optional<S> findOne(Example<S> example) {
		return ncr.findOne(example);
	}

	@Override
	public Page<NivelesContenedoresVO> findAll(Pageable pageable) {
		return ncr.findAll(pageable);
	}

	@Override
	public List<NivelesContenedoresVO> findAll() {
		return ncr.findAll();
	}

	@Override
	public List<NivelesContenedoresVO> findAll(Sort sort) {
		return ncr.findAll(sort);
	}

	@Override
	public List<NivelesContenedoresVO> findAllById(Iterable<Integer> ids) {
		return ncr.findAllById(ids);
	}

	@Override
	public <S extends NivelesContenedoresVO> List<S> saveAll(Iterable<S> entities) {
		return ncr.saveAll(entities);
	}

	@Override
	public Optional<NivelesContenedoresVO> findById(Integer id) {
		return ncr.findById(id);
	}

	@Override
	public void flush() {
		ncr.flush();
	}

	@Override
	public <S extends NivelesContenedoresVO> S saveAndFlush(S entity) {
		return ncr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return ncr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<NivelesContenedoresVO> entities) {
		ncr.deleteInBatch(entities);
	}

	@Override
	public <S extends NivelesContenedoresVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return ncr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		ncr.deleteAllInBatch();
	}

	@Override
	public NivelesContenedoresVO getOne(Integer id) {
		return ncr.getOne(id);
	}

	@Override
	public <S extends NivelesContenedoresVO> long count(Example<S> example) {
		return ncr.count(example);
	}

	@Override
	public <S extends NivelesContenedoresVO> boolean exists(Example<S> example) {
		return ncr.exists(example);
	}

	@Override
	public <S extends NivelesContenedoresVO> List<S> findAll(Example<S> example) {
		return ncr.findAll(example);
	}

	@Override
	public long count() {
		return ncr.count();
	}

	@Override
	public void deleteById(Integer id) {
		ncr.deleteById(id);
	}

	@Override
	public <S extends NivelesContenedoresVO> List<S> findAll(Example<S> example, Sort sort) {
		return ncr.findAll(example, sort);
	}

	@Override
	public void delete(NivelesContenedoresVO entity) {
		ncr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends NivelesContenedoresVO> entities) {
		ncr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ncr.deleteAll();
	}

	
	

}
