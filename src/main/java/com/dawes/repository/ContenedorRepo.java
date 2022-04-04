package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedorVO;


@Repository
public interface ContenedorRepo extends JpaRepository<ContenedorVO, Integer> {

}
