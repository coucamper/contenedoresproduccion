package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.UsuarioRolVO;

@Repository
public interface UsuarioRolRepo extends CrudRepository<UsuarioRolVO, Integer> {

}
