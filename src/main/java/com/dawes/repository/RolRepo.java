package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.RolVO;

@Repository
public interface RolRepo extends CrudRepository<RolVO, Integer> {
	
	RolVO findByNombre(String nombre);

}
