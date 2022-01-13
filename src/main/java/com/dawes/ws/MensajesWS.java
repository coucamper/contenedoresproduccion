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

import com.dawes.modelos.MensajeVO;
import com.dawes.repository.MensajeRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MensajesWS {
	
	@Autowired
	MensajeRepo mr;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/mensaje")
	public ResponseEntity<?> leerTodos(){
		List<MensajeVO> lista = (List<MensajeVO>) mr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/mensaje/{idmensaje}")
		public ResponseEntity<?> leerPorId(@PathVariable int idmensaje) {
			Optional<MensajeVO> c = mr.findById(idmensaje);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/mensaje")
		public ResponseEntity<?> insertar(@RequestBody MensajeVO mensaje) {
			mr.save(mensaje);
			return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/mensaje/{idexport}")
		public ResponseEntity<?> modificar(@PathVariable int idmensaje, @RequestBody MensajeVO mensaje) {
			if (mr.findById(idmensaje).isPresent()) {
				mensaje.setIdmensaje(idmensaje);
				mr.save(mensaje);
				return ResponseEntity.ok(mensaje);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/mensaje/{idexport}")
		public ResponseEntity<?> borrar(@PathVariable int idmensaje) {
			if (mr.findById(idmensaje).isPresent()) {
				MensajeVO p = mr.findById(idmensaje).get();
				mr.deleteById(idmensaje);
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
