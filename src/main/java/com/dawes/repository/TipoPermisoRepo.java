package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoPermisoVO;

@Repository
public interface TipoPermisoRepo extends CrudRepository<TipoPermisoVO, Integer> {

}
