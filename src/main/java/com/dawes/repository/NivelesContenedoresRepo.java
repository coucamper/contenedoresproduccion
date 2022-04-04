package com.dawes.repository;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.NivelesContenedoresVO;

@Repository
public interface NivelesContenedoresRepo extends JpaRepository<NivelesContenedoresVO, Integer> {
	
	@Query("select ncr from NivelesContenedoresVO ncr where ncr.pesaje.idpesaje=:idpesaje")
	List<NivelesContenedoresVO> NivelesContenedoresPorRuta(int idpesaje);

	@Query("select ncr from NivelesContenedoresVO ncr where ncr.pesaje.idpesaje=:idpesaje")
	List<NivelesContenedoresVO> NivelesContenedoresPorRuta2(int idpesaje, Pageable pageable);
	
	
	@Query("select ncr from NivelesContenedoresVO ncr where ncr.idnivelcontenedor=:idnivelcontenedor")
	List<NivelesContenedoresVO> NivelesContenedoresPorIdnivelcontenedor(int idnivelcontenedor);
	
	
	
	
}
