package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ClaseExportacionesVO;

@Repository
public interface ClaseExportacionesRepo extends CrudRepository<ClaseExportacionesVO, Integer> {
	
	

}
