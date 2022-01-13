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

import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.RutaVO;
import com.dawes.repository.PesajeRepo;
import com.dawes.repository.VehiculosPesajesRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PesajesWS {
	
	@Autowired
	PesajeRepo pr;
	
	@Autowired
	VehiculosPesajesRepo vpr;
	
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/pesaje")
	public ResponseEntity<?> leerTodos(){
		List<PesajeVO> lista = (List<PesajeVO>) pr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/pesaje/{idpesaje}")
		public ResponseEntity<?> leerPorId(@PathVariable int idpesaje) {
			Optional<PesajeVO> c = pr.findById(idpesaje);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/pesaje")
		public ResponseEntity<?> insertar(@RequestBody PesajeVO pesaje) {
			pr.save(pesaje);
			return ResponseEntity.status(HttpStatus.CREATED).body(pesaje);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/pesaje/{idpesaje}")
		public ResponseEntity<?> modificar(@PathVariable int idpesaje, @RequestBody PesajeVO pesaje) {
			if (pr.findById(idpesaje).isPresent()) {
				pesaje.setIdpesaje(idpesaje);
				pr.save(pesaje);
				return ResponseEntity.ok(pesaje);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/pesaje/{idpesaje}")
		public ResponseEntity<?> borrar(@PathVariable int idpesaje) {
			if (pr.findById(idpesaje).isPresent()) {
				PesajeVO p = pr.findById(idpesaje).get();
				pr.deleteById(idpesaje);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

		

		
		
//		public long sumar(){
//			
//			if(pr.findById(idpesaje).ruta)
//				
//			long pesajessum = pr.sumPesajes();
//			return pesajessum;
//		}

}
