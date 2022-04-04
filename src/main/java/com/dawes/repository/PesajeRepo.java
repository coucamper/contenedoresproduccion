package com.dawes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.RutaVO;

@Repository
public interface PesajeRepo extends JpaRepository<PesajeVO, Integer> {

	@Query(value = "SELECT sum(pesaje) FROM PesajeVO")
    public Long sumPesajes();
	
	  @Query(value = "SELECT p.idruta, sum(p.pesaje) FROM PesajeVO p where p.fechapesaje between '2022-02-02' and '2022-03-16' group by p.idruta", nativeQuery = true)
	  List<PesajeVO> findByfechapesajeBetweenSuma(LocalDate fechainicio, LocalDate fechafin);
	
	
	  List<PesajeVO> findByfechapesajeBetween(LocalDate fechainicio, LocalDate fechafin);
	  
	  PesajeVO findByFechapesajeAndOperarioAndRuta(LocalDate fechapesaje, EmpleadoVO operario, RutaVO ruta);
}
