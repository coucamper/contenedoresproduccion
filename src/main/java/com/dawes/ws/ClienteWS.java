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
import com.dawes.modelos.ClienteVO;
import com.dawes.repository.ClienteRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClienteWS {
	
	@Autowired
	ClienteRepo cr;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/cliente")
	public ResponseEntity<?> leerTodos(){
		List<ClienteVO> lista = (List<ClienteVO>) cr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/cliente/{idcliente}")
		public ResponseEntity<?> leerPorId(@PathVariable int idcliente) {
			Optional<ClienteVO> c = cr.findById(idcliente);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/cliente")
		public ResponseEntity<?> insertar(@RequestBody ClienteVO cliente) {
			cr.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/cliente/{idclase}")
		public ResponseEntity<?> modificar(@PathVariable int idcliente, @RequestBody ClienteVO cliente) {
			if (cr.findById(idcliente).isPresent()) {
				cliente.setIdcliente(idcliente);
				cr.save(cliente);
				return ResponseEntity.ok(cliente);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/cliente/{idclase}")
		public ResponseEntity<?> borrar(@PathVariable int idcliente) {
			if (cr.findById(idcliente).isPresent()) {
				ClienteVO p = cr.findById(idcliente).get();
				cr.deleteById(idcliente);
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
