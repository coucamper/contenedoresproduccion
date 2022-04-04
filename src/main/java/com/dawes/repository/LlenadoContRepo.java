package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.LlenadoContVO;

@Repository
public interface LlenadoContRepo extends CrudRepository<LlenadoContVO, Integer> {

}
