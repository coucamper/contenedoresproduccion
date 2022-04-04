package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.MantenimientoVO;

@Repository
public interface MantenimientoRepo extends JpaRepository<MantenimientoVO, Integer> {
	
	@Query("select m from MantenimientoVO m where m.idvehiculo.idvehiculo=:idvehiculo")
	List<MantenimientoVO> BuscarMantenimientosVehiculo(int idvehiculo);

}
