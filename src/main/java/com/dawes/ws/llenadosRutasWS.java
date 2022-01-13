package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.modelos.llenadosRutaVO;
import com.dawes.servicioimpl.llenadosRutaServiceImpl;

@RestController
public class llenadosRutasWS {

	@Autowired
	llenadosRutaServiceImpl lrsi;
	
	

	@GetMapping("/llenaruta")
	public ResponseEntity<?> leerTodos(){
		List<llenadosRutaVO> lista = (List<llenadosRutaVO>) lrsi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un empleado en concreto
		@GetMapping("/llenaruta/{idllenaruta}")
		public ResponseEntity<?> leerPorId(@PathVariable int idllenaruta) {
			Optional<llenadosRutaVO> c = lrsi.findById(idllenaruta);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un empleado
		@PostMapping("/llenaruta")
		public ResponseEntity<?> insertar(@RequestBody llenadosRutaVO llenadoruta) {
			lrsi.save(llenadoruta);
			return ResponseEntity.status(HttpStatus.CREATED).body(llenadoruta);
		}
		
		// Servicio para modificar un empleado
		@PutMapping("/llenaruta/{idllenaruta}")
		public ResponseEntity<?> modificar(@PathVariable int idllenaruta, @RequestBody llenadosRutaVO empleado) {
			if (lrsi.findById(idllenaruta).isPresent()) {
				empleado.setIdllenadosruta(idllenaruta);
				lrsi.save(empleado);
				return ResponseEntity.ok(empleado);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		

		
		
		
		// Servicio para eliminar un empleado
		@DeleteMapping("/llenaruta/{idllenaruta}")
		public ResponseEntity<?> borrar(@PathVariable int idllenaruta) {
			if (lrsi.findById(idllenaruta).isPresent()) {
				llenadosRutaVO p = lrsi.findById(idllenaruta).get();
				lrsi.deleteById(idllenaruta);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}
}
