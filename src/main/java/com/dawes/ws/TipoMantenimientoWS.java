package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.TipoMantenimientoVO;
import com.dawes.services.TipoMantenimientoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TipoMantenimientoWS {
	
	@Autowired
	TipoMantenimientoService tms;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tipomantenimiento")
	public ResponseEntity<?> leerTodos() {
		List<TipoMantenimientoVO> lista = (List<TipoMantenimientoVO>) tms.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tipomantenimiento/{idtipomantenimiento}")
	public ResponseEntity<?> leerPorId(@PathVariable int idtipomantenimiento) {
		Optional<TipoMantenimientoVO> c = tms.findById(idtipomantenimiento);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
