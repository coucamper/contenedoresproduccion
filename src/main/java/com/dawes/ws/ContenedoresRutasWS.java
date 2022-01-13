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

import com.dawes.modelos.ContenedorVO;
import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.repository.ContenedoresRutasRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ContenedoresRutasWS {
	
	@Autowired
	ContenedoresRutasRepo crr;
	
	
	// Servicio web para consultar todos los proveedores
		@GetMapping("/contenedoresrutasws")
		public ResponseEntity<?> leerTodos(){
			List<ContenedoresRutasVO> lista = (List<ContenedoresRutasVO>) crr.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		
		// Servicio para consultar un proveedor en concreto
			@GetMapping("/contenedorruta/{idcontenedorruta}")
			public ResponseEntity<?> leerPorId(@PathVariable int idcontenedorruta) {
				Optional<ContenedoresRutasVO> c = crr.findById(idcontenedorruta);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			
			
			// Servicio para crear un ContenedorRuta
			@PostMapping("/contenedorruta")
			public ResponseEntity<?> insertar(@RequestBody ContenedoresRutasVO contenedorruta) {
				crr.save(contenedorruta);
				return ResponseEntity.status(HttpStatus.CREATED).body(contenedorruta);
			}
			
			
			
			
			
			
			// Servicio para modificar un ContenedorRuta
			@PutMapping("/contenedorruta/{idcontenedorruta}")
			public ResponseEntity<?> modificar(@PathVariable int idcontenedorruta, @RequestBody ContenedoresRutasVO contenedorruta) {
				if (crr.findById(idcontenedorruta).isPresent()) {
					contenedorruta.setIdcontenrutas(idcontenedorruta);
					crr.save(contenedorruta);
					return ResponseEntity.ok(contenedorruta);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			// Servicio para eliminar un ContenedorRuta
			@DeleteMapping("/contenedorruta/{idcontenedorruta}")
			public ResponseEntity<?> borrar(@PathVariable int idcontenedorruta) {
				if (crr.findById(idcontenedorruta).isPresent()) {
					ContenedoresRutasVO p = crr.findById(idcontenedorruta).get();
					crr.deleteById(idcontenedorruta);
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
