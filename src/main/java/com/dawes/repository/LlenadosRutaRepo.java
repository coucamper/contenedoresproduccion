package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.llenadosRutaVO;

@Repository
public interface LlenadosRutaRepo extends CrudRepository<llenadosRutaVO, Integer> {

}
