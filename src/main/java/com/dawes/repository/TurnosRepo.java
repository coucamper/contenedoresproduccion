package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TurnoVO;

@Repository
public interface TurnosRepo extends CrudRepository<TurnoVO, Integer> {

}
