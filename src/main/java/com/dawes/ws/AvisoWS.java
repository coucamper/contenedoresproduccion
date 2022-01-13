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

import com.dawes.modelos.AvisoVO;
import com.dawes.modelos.RutaVO;
import com.dawes.services.AvisoService;

@RestController
public class AvisoWS {
	
	@Autowired
	AvisoService as;
	

	// Servicio web para consultar todos los proveedores
	@GetMapping("/aviso")
	public ResponseEntity<?> leerTodos(){
		List<AvisoVO> lista = (List<AvisoVO>) as.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/aviso/{idaviso}")
		public ResponseEntity<?> leerPorId(@PathVariable int idaviso) {
			Optional<AvisoVO> c = as.findById(idaviso);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/aviso")
		public ResponseEntity<?> insertar(@RequestBody AvisoVO aviso) {
			as.save(aviso);
			return ResponseEntity.status(HttpStatus.CREATED).body(aviso);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/aviso/{idaviso}")
		public ResponseEntity<?> modificar(@PathVariable int idaviso, @RequestBody AvisoVO aviso) {
			if (as.findById(idaviso).isPresent()) {
				aviso.setIdaviso(idaviso);
				as.save(aviso);
				return ResponseEntity.ok(aviso);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/ruta/{idaviso}")
		public ResponseEntity<?> borrar(@PathVariable int idaviso) {
			if (as.findById(idaviso).isPresent()) {
				AvisoVO p = as.findById(idaviso).get();
				as.deleteById(idaviso);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

}
