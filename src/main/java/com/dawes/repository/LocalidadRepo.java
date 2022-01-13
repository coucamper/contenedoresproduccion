package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.LocalidadVO;

@Repository
public interface LocalidadRepo extends CrudRepository<LocalidadVO, Integer> {

}
