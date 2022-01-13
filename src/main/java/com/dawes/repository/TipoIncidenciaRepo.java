package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoIncidenciaVO;

@Repository
public interface TipoIncidenciaRepo extends CrudRepository<TipoIncidenciaVO, Integer> {

}
