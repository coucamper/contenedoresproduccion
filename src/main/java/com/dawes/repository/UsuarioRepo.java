package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.UsuarioVO;

@Repository
public interface UsuarioRepo extends CrudRepository<UsuarioVO, Integer> {
	
	UsuarioVO findByUsername(String username);

}
