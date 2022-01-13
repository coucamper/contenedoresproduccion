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

import com.dawes.modelos.ClaseExportacionesVO;
import com.dawes.modelos.ContenedorVO;
import com.dawes.repository.ClaseExportacionesRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClaseExportacionesWS {
	
	@Autowired
	ClaseExportacionesRepo cer;
	
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/claseexport")
	public ResponseEntity<?> leerTodos(){
		List<ClaseExportacionesVO> lista = (List<ClaseExportacionesVO>) cer.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/claseexport/{idclaseexportacion}")
		public ResponseEntity<?> leerPorId(@PathVariable int idclaseexportacion) {
			Optional<ClaseExportacionesVO> c = cer.findById(idclaseexportacion);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/claseexport")
		public ResponseEntity<?> insertar(@RequestBody ClaseExportacionesVO claseexportacion) {
			cer.save(claseexportacion);
			return ResponseEntity.status(HttpStatus.CREATED).body(claseexportacion);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/claseexport/{idclaseexportacion}")
		public ResponseEntity<?> modificar(@PathVariable int idclaseexportacion, @RequestBody ClaseExportacionesVO claseexportacion) {
			if (cer.findById(idclaseexportacion).isPresent()) {
				claseexportacion.setIdclaseexportacion(idclaseexportacion);
				cer.save(claseexportacion);
				return ResponseEntity.ok(claseexportacion);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/claseexport/{idclaseexportacion}")
		public ResponseEntity<?> borrar(@PathVariable int idclaseexportacion) {
			if (cer.findById(idclaseexportacion).isPresent()) {
				ClaseExportacionesVO p = cer.findById(idclaseexportacion).get();
				cer.deleteById(idclaseexportacion);
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
