package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.repository.ReceptoresAvisoRepo;
import com.dawes.services.ReceptoresAvisoService;
import com.dawes.services.ReceptoresAvisoVO;

@Service
public class ReceptoresAvisoServiceImpl implements ReceptoresAvisoRepo, ReceptoresAvisoService {
	
	@Autowired
	ReceptoresAvisoRepo rar;

	@Override
	public <S extends ReceptoresAvisoVO> S save(S entity) {
		return rar.save(entity);
	}

	@Override
	public <S extends ReceptoresAvisoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rar.saveAll(entities);
	}

	@Override
	public Optional<ReceptoresAvisoVO> findById(Integer id) {
		return rar.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rar.existsById(id);
	}

	@Override
	public Iterable<ReceptoresAvisoVO> findAll() {
		return rar.findAll();
	}

	@Override
	public Iterable<ReceptoresAvisoVO> findAllById(Iterable<Integer> ids) {
		return rar.findAllById(ids);
	}

	@Override
	public long count() {
		return rar.count();
	}

	@Override
	public void deleteById(Integer id) {
		rar.deleteById(id);
	}

	@Override
	public void delete(ReceptoresAvisoVO entity) {
		rar.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ReceptoresAvisoVO> entities) {
		rar.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rar.deleteAll();
	}

	

}
