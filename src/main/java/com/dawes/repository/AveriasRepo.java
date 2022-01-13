package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.AveriasVO;

@Repository
public interface AveriasRepo extends CrudRepository<AveriasVO, Integer> {

}
