package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.AvisoVO;

@Repository
public interface AvisoRepo extends JpaRepository<AvisoVO, Integer> {

}
