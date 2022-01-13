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

import com.dawes.modelos.ClientesExportacionesVO;
import com.dawes.repository.ClientesExportacionesRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientesExportacionesWS {
	
	@Autowired
	ClientesExportacionesRepo cer;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/clientesexportaciones")
	public ResponseEntity<?> leerTodos(){
		List<ClientesExportacionesVO> lista = (List<ClientesExportacionesVO>) cer.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/clientesexportaciones/{idclienteexport}")
		public ResponseEntity<?> leerPorId(@PathVariable int idclienteexport) {
			Optional<ClientesExportacionesVO> c = cer.findById(idclienteexport);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/clientesexportaciones")
		public ResponseEntity<?> insertar(@RequestBody ClientesExportacionesVO clienteexportacion) {
			cer.save(clienteexportacion);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteexportacion);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/clientesexportaciones/{idclienteexport}")
		public ResponseEntity<?> modificar(@PathVariable int idclienteexport, @RequestBody ClientesExportacionesVO clienteexportacion) {
			if (cer.findById(idclienteexport).isPresent()) {
				clienteexportacion.setIdclienteexport(idclienteexport);
				cer.save(clienteexportacion);
				return ResponseEntity.ok(clienteexportacion);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/clientesexportaciones/{idclienteexport}")
		public ResponseEntity<?> borrar(@PathVariable int idclienteexport) {
			if (cer.findById(idclienteexport).isPresent()) {
				ClientesExportacionesVO p = cer.findById(idclienteexport).get();
				cer.deleteById(idclienteexport);
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
