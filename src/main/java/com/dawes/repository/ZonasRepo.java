package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ZonasVO;

@Repository
public interface ZonasRepo extends CrudRepository<ZonasVO, Integer> {
	

}
