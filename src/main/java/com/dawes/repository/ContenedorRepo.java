package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedorVO;


@Repository
public interface ContenedorRepo extends CrudRepository<ContenedorVO, Integer> {

}
