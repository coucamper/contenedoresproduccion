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

import com.dawes.modelos.AveriasVO;
import com.dawes.modelos.PesajeVO;
import com.dawes.servicioimpl.AveriasServiceImpl;

@RestController
public class AveriasWS {

	@Autowired
	AveriasServiceImpl asi;
	

	// Servicio web para consultar todos los proveedores
	@GetMapping("/averias")
	public ResponseEntity<?> leerTodos(){
		List<AveriasVO> lista = (List<AveriasVO>) asi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/averias/{idaveria}")
		public ResponseEntity<?> leerPorId(@PathVariable int idaveria) {
			Optional<AveriasVO> c = asi.findById(idaveria);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/averias")
		public ResponseEntity<?> insertar(@RequestBody AveriasVO averia) {
			asi.save(averia);
			return ResponseEntity.status(HttpStatus.CREATED).body(averia);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/averias/{idaveria}")
		public ResponseEntity<?> modificar(@PathVariable int idaveria, @RequestBody AveriasVO averia) {
			if (asi.findById(idaveria).isPresent()) {
				averia.setIdaveria(idaveria);
				asi.save(averia);
				return ResponseEntity.ok(averia);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/averias/{idaveria}")
		public ResponseEntity<?> borrar(@PathVariable int idaveria) {
			if (asi.findById(idaveria).isPresent()) {
				AveriasVO p = asi.findById(idaveria).get();
				asi.deleteById(idaveria);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

}
