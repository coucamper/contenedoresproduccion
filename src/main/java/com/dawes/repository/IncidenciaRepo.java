package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.IncidenciaVO;

@Repository
public interface IncidenciaRepo extends CrudRepository<IncidenciaVO, Integer> {

}
