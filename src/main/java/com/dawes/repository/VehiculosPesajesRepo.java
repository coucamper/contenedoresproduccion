package com.dawes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.VehiculosPesajesVO;

@Repository
public interface VehiculosPesajesRepo extends JpaRepository<VehiculosPesajesVO, Integer> {
	
	@Query(value = "SELECT sum(pesajes.pesaje) FROM VehiculosPesajesVO WHERE pesajes.ruta.idruta=:idruta")
    public Long sumPesajes(int idruta);



}
