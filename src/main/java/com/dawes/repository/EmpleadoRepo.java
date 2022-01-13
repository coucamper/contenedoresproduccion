package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.EmpleadoVO;

@Repository
public interface EmpleadoRepo extends CrudRepository<EmpleadoVO, Integer> {


}
