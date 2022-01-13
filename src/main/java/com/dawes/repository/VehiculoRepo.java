package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.VehiculoVO;

@Repository
public interface VehiculoRepo extends CrudRepository<VehiculoVO, Integer> {
	
	

}
