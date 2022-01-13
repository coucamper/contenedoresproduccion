package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.MensajeVO;

@Repository
public interface MensajeRepo extends CrudRepository<MensajeVO, Integer> {

}
