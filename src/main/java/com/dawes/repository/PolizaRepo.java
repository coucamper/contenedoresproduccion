package com.dawes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.PolizaVO;

@Repository
public interface PolizaRepo extends JpaRepository<PolizaVO, Integer> {
	
	@Query("select p from PolizaVO p where p.vehiculo.idvehiculo=:idvehiculo")
	Optional<PolizaVO> BuscarPolizaPorIdVehiculo(int idvehiculo);

}
