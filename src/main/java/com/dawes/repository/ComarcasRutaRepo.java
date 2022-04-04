package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ComarcasRutaVO;

@Repository
public interface ComarcasRutaRepo extends CrudRepository<ComarcasRutaVO, Integer> {

}
