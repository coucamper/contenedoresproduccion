package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.ContenedorVO;
import com.dawes.repository.ContenedorRepo;

//@PreAuthorize("authenticated")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ContenedoresWS {
	
	@Autowired
	ContenedorRepo cr;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/contenedor")
	public ResponseEntity<?> leerTodos(){
		List<ContenedorVO> lista = (List<ContenedorVO>) cr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/contenedor/{idcontenedor}")
		public ResponseEntity<?> leerPorId(@PathVariable int idcontenedor) {
			Optional<ContenedorVO> c = cr.findById(idcontenedor);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/contenedor")
		public ResponseEntity<?> insertar(@RequestBody ContenedorVO contenedor) {
			cr.save(contenedor);
			return ResponseEntity.status(HttpStatus.CREATED).body(contenedor);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/contenedor/{idcontenedor}")
		public ResponseEntity<?> modificar(@PathVariable int idcontenedor, @RequestBody ContenedorVO contenedor) {
			if (cr.findById(idcontenedor).isPresent()) {
				contenedor.setIdcontenedor(idcontenedor);
				cr.save(contenedor);
				return ResponseEntity.ok(contenedor);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/contenedor/{idcontenedor}")
		public ResponseEntity<?> borrar(@PathVariable int idcontenedor) {
			if (cr.findById(idcontenedor).isPresent()) {
				ContenedorVO p = cr.findById(idcontenedor).get();
				cr.deleteById(idcontenedor);
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
