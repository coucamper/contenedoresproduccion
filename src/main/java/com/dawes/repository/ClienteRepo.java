package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ClienteVO;

@Repository
public interface ClienteRepo extends CrudRepository<ClienteVO, Integer> {
	

}
