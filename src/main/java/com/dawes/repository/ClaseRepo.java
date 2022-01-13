package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ClaseVO;

@Repository
public interface ClaseRepo extends CrudRepository<ClaseVO, Integer> {

}
