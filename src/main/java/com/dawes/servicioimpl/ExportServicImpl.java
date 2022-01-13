package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dawes.modelos.ExportVO;
import com.dawes.repository.ExportRepo;
import com.dawes.services.ExportacionService;



@Primary
@Service
public class ExportServicImpl implements ExportRepo, ExportacionService {

	@Autowired
	ExportRepo ex;

	@Override
	public <S extends ExportVO> S save(S entity) {
		return ex.save(entity);
	}

	@Override
	public <S extends ExportVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ex.saveAll(entities);
	}

	@Override
	public Optional<ExportVO> findById(Integer id) {
		return ex.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ex.existsById(id);
	}

	@Override
	public Iterable<ExportVO> findAll() {
		return ex.findAll();
	}

	@Override
	public Iterable<ExportVO> findAllById(Iterable<Integer> ids) {
		return ex.findAllById(ids);
	}

	@Override
	public long count() {
		return ex.count();
	}

	@Override
	public void deleteById(Integer id) {
		ex.deleteById(id);
	}

	@Override
	public void delete(ExportVO entity) {
		ex.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ExportVO> entities) {
		ex.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ex.deleteAll();
	}

	@Override
	public Long sumPesosLocalesPorCliente(int idcliente) {
		return ex.sumPesosLocalesPorCliente(idcliente);
	}

	@Override
	public List<ExportVO> findAllByEstadopago(String estadopago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long estadopago(String estadopago) {
		// TODO Auto-generated method stub
		return null;
	}



}
