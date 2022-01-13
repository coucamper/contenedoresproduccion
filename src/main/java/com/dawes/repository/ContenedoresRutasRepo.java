package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedoresRutasVO;

@Repository
public interface ContenedoresRutasRepo extends CrudRepository<ContenedoresRutasVO, Integer> {

	@Query("select cr from ContenedoresRutasVO cr where cr.idcontenrutas.rutas.idruta =:idruta")
	List<ContenedoresRutasVO> BuscarContenedoresRuta(int idruta);
	
	
}
