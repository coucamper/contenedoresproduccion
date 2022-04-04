package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ConcejosComarcaVO;
import com.dawes.modelos.NivelesContenedoresVO;

@Repository
public interface ConcejosComarcaRepo extends CrudRepository<ConcejosComarcaVO, Integer> {

	@Query("select cc from ConcejosComarcaVO cc where cc.comarca.idcomarca=:idcomarca")
	List<ConcejosComarcaVO> ConcejosPorComarca(int idcomarca);
}
