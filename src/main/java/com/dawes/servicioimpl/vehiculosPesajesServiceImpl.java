package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
	public <S extends VehiculosPesajesVO> S save(S entity) {
		return vpr.save(entity);
	}

	@Override
	public <S extends VehiculosPesajesVO> Iterable<S> saveAll(Iterable<S> entities) {
		return vpr.saveAll(entities);
	}

	@Override
	public Optional<VehiculosPesajesVO> findById(Integer id) {
		return vpr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return vpr.existsById(id);
	}

	@Override
	public Iterable<VehiculosPesajesVO> findAll() {
		return vpr.findAll();
	}

	@Override
	public Iterable<VehiculosPesajesVO> findAllById(Iterable<Integer> ids) {
		return vpr.findAllById(ids);
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
	public Long sumPesajes(int idruta) {
		return vpr.sumPesajes(idruta);
	}

	@Override
	public Long sumPesajes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
