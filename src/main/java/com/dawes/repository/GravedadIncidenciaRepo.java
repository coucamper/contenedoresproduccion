package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.GravedadIncidenciaVO;

@Repository
public interface GravedadIncidenciaRepo extends CrudRepository<GravedadIncidenciaVO, Integer> {

}
