package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.PermisosRetribuidosEmpleadoVO;

@Repository
public interface PermisosRetribEmpleadoRepo extends CrudRepository<PermisosRetribuidosEmpleadoVO, Integer> {

}
