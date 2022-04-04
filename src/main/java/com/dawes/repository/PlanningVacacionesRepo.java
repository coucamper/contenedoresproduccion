package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.PlanningVacacionesVO;


@Repository
public interface PlanningVacacionesRepo extends JpaRepository<PlanningVacacionesVO, Integer> {
	
	@Query("select v from PlanningVacacionesVO v where v.empleado.idempleado=:idempleado")
	List<PlanningVacacionesVO> BuscarVacacionesEmpleado (int idempleado);

}
