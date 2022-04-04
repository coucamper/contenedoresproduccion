package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.MensajeVO;

@Repository
public interface MensajeRepo extends CrudRepository<MensajeVO, Integer> {
	
	@Query("select m from MensajeVO m where m.receptor.idempleado=:idreceptor")
	List<MensajeVO> BuscarMensajesPorReceptor (int idreceptor);

}
