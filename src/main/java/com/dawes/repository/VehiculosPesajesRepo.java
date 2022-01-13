package com.dawes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.VehiculosPesajesVO;

@Repository
public interface VehiculosPesajesRepo extends CrudRepository<VehiculosPesajesVO, Integer> {
	
	@Query(value = "SELECT sum(pesajes.pesaje) FROM VehiculosPesajesVO WHERE pesajes.ruta.idruta=:idruta")
    public Long sumPesajes(int idruta);



}
