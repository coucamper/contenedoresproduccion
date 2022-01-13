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

import com.dawes.modelos.LocalidadVO;
import com.dawes.modelos.ZonasVO;
import com.dawes.services.LocalidadService;

@RestController
public class LocalidadWS {
	
	@Autowired
	LocalidadService ls;
	
	// Servicio web para consultar todos los proveedores
		@GetMapping("/localidad")
		public ResponseEntity<?> leerTodos(){
			List<LocalidadVO> lista = (List<LocalidadVO>) ls.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		
		// Servicio para consultar un proveedor en concreto
			@GetMapping("/localidad/{idlocalidad}")
			public ResponseEntity<?> leerPorId(@PathVariable int idlocalidad) {
				Optional<LocalidadVO> c = ls.findById(idlocalidad);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			
			
			// Servicio para crear un ContenedorRuta
			@PostMapping("/localidad")
			public ResponseEntity<?> insertar(@RequestBody LocalidadVO localidad) {
				ls.save(localidad);
				return ResponseEntity.status(HttpStatus.CREATED).body(localidad);
			}
			
			
			
			
			
			
			// Servicio para modificar un ContenedorRuta
			@PutMapping("/localidad/{idlocalidad}")
			public ResponseEntity<?> modificar(@PathVariable int idlocalidad, @RequestBody LocalidadVO localidad) {
				if (ls.findById(idlocalidad).isPresent()) {
					localidad.setIdlocalidad(idlocalidad);
					ls.save(localidad);
					return ResponseEntity.ok(localidad);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			// Servicio para eliminar un ContenedorRuta
			@DeleteMapping("/localidad/{idlocalidad}")
			public ResponseEntity<?> borrar(@PathVariable int idlocalidad) {
				if (ls.findById(idlocalidad).isPresent()) {
					LocalidadVO p = ls.findById(idlocalidad).get();
					ls.deleteById(idlocalidad);
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.notFound().build();
				}			
			}

}
