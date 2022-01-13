package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.PlanningVacacionesVO;


@Repository
public interface PlanningVacacionesRepo extends CrudRepository<PlanningVacacionesVO, Integer> {

}
