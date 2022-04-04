package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContratoEmpleadoVO;

@Repository
public interface ContratoEmpleadoRepo extends JpaRepository<ContratoEmpleadoVO, Integer> {

}
