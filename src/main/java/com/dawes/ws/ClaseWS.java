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

import com.dawes.modelos.ClaseVO;
import com.dawes.repository.ClaseRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClaseWS {
	
	@Autowired
	ClaseRepo cr;
	
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/clase")
	public ResponseEntity<?> leerTodos(){
		List<ClaseVO> lista = (List<ClaseVO>) cr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/clase/{idclase}")
		public ResponseEntity<?> leerPorId(@PathVariable int idclase) {
			Optional<ClaseVO> c = cr.findById(idclase);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/clase")
		public ResponseEntity<?> insertar(@RequestBody ClaseVO clase) {
			cr.save(clase);
			return ResponseEntity.status(HttpStatus.CREATED).body(clase);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/clase/{idclase}")
		public ResponseEntity<?> modificar(@PathVariable int idclase, @RequestBody ClaseVO clase) {
			if (cr.findById(idclase).isPresent()) {
				clase.setIdclase(idclase);
				cr.save(clase);
				return ResponseEntity.ok(clase);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/clase/{idclase}")
		public ResponseEntity<?> borrar(@PathVariable int idclase) {
			if (cr.findById(idclase).isPresent()) {
				ClaseVO p = cr.findById(idclase).get();
				cr.deleteById(idclase);
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
