package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoPermisoNrVO;

@Repository
public interface TipoPermisoNrRepo extends CrudRepository<TipoPermisoNrVO, Integer> {

}
