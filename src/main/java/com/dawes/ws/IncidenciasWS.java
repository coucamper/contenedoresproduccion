package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.IncidenciaVO;
import com.dawes.repository.IncidenciaRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class IncidenciasWS {
	
	
	@Autowired
	IncidenciaRepo ir;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/incidencia")
	public ResponseEntity<?> leerTodos(){
		List<IncidenciaVO> lista = (List<IncidenciaVO>) ir.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/incidencia/{idincidencia}")
		public ResponseEntity<?> leerPorId(@PathVariable int idincidencia) {
			Optional<IncidenciaVO> c = ir.findById(idincidencia);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/incidencia")
		public ResponseEntity<?> insertar(@RequestBody IncidenciaVO incidencia) {
			ir.save(incidencia);
			return ResponseEntity.status(HttpStatus.CREATED).body(incidencia);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/incidencia/{idexport}")
		public ResponseEntity<?> modificar(@PathVariable int idincidencia, @RequestBody IncidenciaVO incidencia) {
			if (ir.findById(idincidencia).isPresent()) {
				incidencia.setIdincidencia(idincidencia);
				ir.save(incidencia);
				return ResponseEntity.ok(incidencia);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/incidencia/{idexport}")
		public ResponseEntity<?> borrar(@PathVariable int idincidencia) {
			if (ir.findById(idincidencia).isPresent()) {
				IncidenciaVO p = ir.findById(idincidencia).get();
				ir.deleteById(idincidencia);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

		
		/*
		 * 	// Servicio web para consultar todos los proveedores
		@GetMapping("/proveedor")
		public ResponseEntity<?> leerTodos(){
			List<ProveedorVO> lista = (List<ProveedorVO>) pr.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		 */


}
