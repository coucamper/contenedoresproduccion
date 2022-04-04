package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.services.ReceptoresAvisoVO;

@Repository
public interface ReceptoresAvisoRepo extends CrudRepository<ReceptoresAvisoVO, Integer> {

}
