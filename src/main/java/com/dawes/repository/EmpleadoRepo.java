package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.EmpleadoVO;

@Repository
public interface EmpleadoRepo extends JpaRepository<EmpleadoVO, Integer> {
	
	EmpleadoVO findByNif(String nif);

}
