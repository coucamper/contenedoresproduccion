package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.MantenimientoVO;

@Repository
public interface MantenimientoRepo extends CrudRepository<MantenimientoVO, Integer> {

}
