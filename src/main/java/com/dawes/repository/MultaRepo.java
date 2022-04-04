package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.MultaVO;

@Repository
public interface MultaRepo extends JpaRepository<MultaVO, Integer> {

	@Query("select m from MultaVO m where m.vehiculo.idvehiculo=:idvehiculo")
	List<MultaVO> BuscarMultasPorVehiculo(int idvehiculo);
	

}
