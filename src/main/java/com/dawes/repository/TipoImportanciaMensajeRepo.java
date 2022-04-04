package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoImportanciaMensajeVO;

@Repository
public interface TipoImportanciaMensajeRepo extends CrudRepository<TipoImportanciaMensajeVO, Integer> {

}
