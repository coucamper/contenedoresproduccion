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

import com.dawes.modelos.EmpleadoVO;
import com.dawes.repository.EmpleadoRepo;

//@PreAuthorize("authenticated")
@RestController
@CrossOrigin(origins = "htpp://localhost:4200/")
public class EmpleadosWS {
	
	@Autowired
	EmpleadoRepo emr;
	
	
	// Servicio web para consultar todos los empleados
	@GetMapping("/empleado")
	public ResponseEntity<?> leerTodos(){
		List<EmpleadoVO> lista = (List<EmpleadoVO>) emr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un empleado en concreto
		@GetMapping("/empleado/{idempleado}")
		public ResponseEntity<?> leerPorId(@PathVariable int idempleado) {
			Optional<EmpleadoVO> c = emr.findById(idempleado);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un empleado
		@PostMapping("/empleado")
		public ResponseEntity<?> insertar(@RequestBody EmpleadoVO empleado) {
			emr.save(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
		}
		
		// Servicio para modificar un empleado
		@PutMapping("/empleado/{idempleado}")
		public ResponseEntity<?> modificar(@PathVariable int idempleado, @RequestBody EmpleadoVO empleado) {
			if (emr.findById(idempleado).isPresent()) {
				empleado.setIdempleado(idempleado);
				emr.save(empleado);
				return ResponseEntity.ok(empleado);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		

		
		
		
		// Servicio para eliminar un empleado
		@DeleteMapping("/empleado/{idempleado}")
		public ResponseEntity<?> borrar(@PathVariable int idempleado) {
			if (emr.findById(idempleado).isPresent()) {
				EmpleadoVO p = emr.findById(idempleado).get();
				emr.deleteById(idempleado);
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
