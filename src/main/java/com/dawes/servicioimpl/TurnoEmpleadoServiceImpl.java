package com.dawes.servicioimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelos.TurnoEmpleadoVO;
import com.dawes.repository.TurnoEmpleadoRepo;
import com.dawes.services.TurnoEmpleadoService;

@Service
public class TurnoEmpleadoServiceImpl implements TurnoEmpleadoRepo, TurnoEmpleadoService {

	@Autowired
	TurnoEmpleadoRepo ter;

	@Override
	public <S extends TurnoEmpleadoVO> S save(S entity) {
		return ter.save(entity);
	}

	@Override
	public <S extends TurnoEmpleadoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ter.saveAll(entities);
	}

	@Override
	public Optional<TurnoEmpleadoVO> findById(Integer id) {
		return ter.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ter.existsById(id);
	}

	@Override
	public Iterable<TurnoEmpleadoVO> findAll() {
		return ter.findAll();
	}

	@Override
	public Iterable<TurnoEmpleadoVO> findAllById(Iterable<Integer> ids) {
		return ter.findAllById(ids);
	}

	@Override
	public long count() {
		return ter.count();
	}

	@Override
	public void deleteById(Integer id) {
		ter.deleteById(id);
	}

	@Override
	public void delete(TurnoEmpleadoVO entity) {
		ter.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends TurnoEmpleadoVO> entities) {
		ter.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ter.deleteAll();
	}

	@Override
	public List<TurnoEmpleadoVO> findByfechainicioturnoBetween(LocalDate fechainicioturno, LocalDate fechafinturno) {
		return ter.findByfechainicioturnoBetween(fechainicioturno, fechafinturno);
	}


	
	
}
