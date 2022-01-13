package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.RutaVO;

@Repository
public interface RutaRepo extends CrudRepository<RutaVO, Integer> {
	
	@Query("select cr from ContenedoresRutasVO cr where cr.idcontenrutas.rutas.idruta =:idruta")
	List<ContenedoresRutasVO> buscarContenedoresRuta(int idruta);
	
}
