package com.dawes.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedoresRutasVO;

@Primary
@Repository
public interface ContenedoresRutasRepo extends CrudRepository<ContenedoresRutasVO, Integer> {

	@Query("select cr from ContenedoresRutasVO cr where cr.contenedor=:idcontenedor")
	List<ContenedoresRutasVO> BuscarContenedoresRuta(int idcontenedor);

	
}
