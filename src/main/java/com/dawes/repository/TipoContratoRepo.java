package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TipoContratoVO;

@Repository
public interface TipoContratoRepo extends CrudRepository<TipoContratoVO, Integer> {

}
