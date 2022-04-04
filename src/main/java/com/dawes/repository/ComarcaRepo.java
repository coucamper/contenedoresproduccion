package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ComarcaVO;

@Repository
public interface ComarcaRepo extends JpaRepository<ComarcaVO, Integer> {

}
