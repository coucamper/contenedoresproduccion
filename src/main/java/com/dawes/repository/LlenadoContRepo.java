package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.llenadoContVO;

@Repository
public interface LlenadoContRepo extends CrudRepository<llenadoContVO, Integer> {

}
