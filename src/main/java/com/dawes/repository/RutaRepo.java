package com.dawes.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.RutaVO;

@Repository
public interface RutaRepo extends JpaRepository<RutaVO, Integer> {}

