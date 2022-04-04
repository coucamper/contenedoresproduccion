package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dawes.modelos.VehiculosPesajesVO;
import com.dawes.repository.VehiculosPesajesRepo;
import com.dawes.services.VehiculosPesajesService;

@Primary
@Service
public class vehiculosPesajesServiceImpl implements VehiculosPesajesRepo, VehiculosPesajesService {

	@Autowired
	VehiculosPesajesRepo vpr;

	@Override
	public Long sumPesajes(int idruta) {
		return vpr.sumPesajes(idruta);
	}

	@Override
	public <S extends VehiculosPesajesVO> S save(S entity) {
		return vpr.save(entity);
	}

	@Override
	public <S extends VehiculosPesajesVO> Optional<S> findOne(Example<S> example) {
		return vpr.findOne(example);
	}

	@Override
	public Page<VehiculosPesajesVO> findAll(Pageable pageable) {
		return vpr.findAll(pageable);
	}

	@Override
	public List<VehiculosPesajesVO> findAll() {
		return vpr.findAll();
	}

	@Override
	public List<VehiculosPesajesVO> findAll(Sort sort) {
		return vpr.findAll(sort);
	}

	@Override
	public List<VehiculosPesajesVO> findAllById(Iterable<Integer> ids) {
		return vpr.findAllById(ids);
	}

	@Override
	public <S extends VehiculosPesajesVO> List<S> saveAll(Iterable<S> entities) {
		return vpr.saveAll(entities);
	}

	@Override
	public Optional<VehiculosPesajesVO> findById(Integer id) {
		return vpr.findById(id);
	}

	@Override
	public void flush() {
		vpr.flush();
	}

	@Override
	public <S extends VehiculosPesajesVO> S saveAndFlush(S entity) {
		return vpr.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return vpr.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<VehiculosPesajesVO> entities) {
		vpr.deleteInBatch(entities);
	}

	@Override
	public <S extends VehiculosPesajesVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return vpr.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		vpr.deleteAllInBatch();
	}

	@Override
	public VehiculosPesajesVO getOne(Integer id) {
		return vpr.getOne(id);
	}

	@Override
	public <S extends VehiculosPesajesVO> long count(Example<S> example) {
		return vpr.count(example);
	}

	@Override
	public <S extends VehiculosPesajesVO> boolean exists(Example<S> example) {
		return vpr.exists(example);
	}

	@Override
	public <S extends VehiculosPesajesVO> List<S> findAll(Example<S> example) {
		return vpr.findAll(example);
	}

	@Override
	public long count() {
		return vpr.count();
	}

	@Override
	public void deleteById(Integer id) {
		vpr.deleteById(id);
	}

	@Override
	public <S extends VehiculosPesajesVO> List<S> findAll(Example<S> example, Sort sort) {
		return vpr.findAll(example, sort);
	}

	@Override
	public void delete(VehiculosPesajesVO entity) {
		vpr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends VehiculosPesajesVO> entities) {
		vpr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		vpr.deleteAll();
	}

	@Override
	public Long sumPesajes() {
		return vpr.sumPesajes(0);
	}

	
	

}
