package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.PermisosNoRetribEmpleadoVO;

@Repository
public interface PermisosNoRetribEmpleadoRepo extends CrudRepository<PermisosNoRetribEmpleadoVO, Integer> {

}
