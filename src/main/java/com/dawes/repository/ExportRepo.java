package com.dawes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.ExportVO;

@Repository
public interface ExportRepo extends CrudRepository<ExportVO, Integer> {
	
	@Query(value = "SELECT sum(pesolocal) FROM ExportVO WHERE cliente.idcliente=:idcliente")
    public Long sumPesosLocalesPorCliente(int idcliente);
	

	
	
	
	
}
