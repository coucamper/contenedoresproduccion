package com.dawes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.TurnoEmpleadoVO;

@Repository
public interface TurnoEmpleadoRepo extends CrudRepository<TurnoEmpleadoVO, Integer> {
	
	 List<TurnoEmpleadoVO> findByfechainicioturnoBetween(LocalDate fechainicioturno, LocalDate fechafinturno);

}
