package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.AvisoVO;

@Repository
public interface AvisoRepo extends CrudRepository<AvisoVO, Integer> {

}
