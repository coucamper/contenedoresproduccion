package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoMantenimientoVO;

@Repository
public interface TipoMantenimientoRepo extends CrudRepository<TipoMantenimientoVO, Integer> {

}
