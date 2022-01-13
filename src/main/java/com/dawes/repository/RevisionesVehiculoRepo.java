package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.RevisionesVehiculoVO;

@Repository
public interface RevisionesVehiculoRepo extends CrudRepository<RevisionesVehiculoVO, Integer> {

}
