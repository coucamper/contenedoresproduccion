package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.CategoriaVO;

@Repository
public interface CategoriaRepo extends CrudRepository<CategoriaVO, Integer> {

}
