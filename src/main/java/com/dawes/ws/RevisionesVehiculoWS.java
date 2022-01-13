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

import com.dawes.modelos.RevisionesVehiculoVO;
import com.dawes.modelos.RutaVO;
import com.dawes.servicioimpl.RevisionesVehiculoServiceImpl;

@RestController
public class RevisionesVehiculoWS {
	
	@Autowired
	RevisionesVehiculoServiceImpl rvsi;
	
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/revisiones")
	public ResponseEntity<?> leerTodos(){
		List<RevisionesVehiculoVO> lista = (List<RevisionesVehiculoVO>) rvsi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/revisiones/{idrevivehiculo}")
		public ResponseEntity<?> leerPorId(@PathVariable int idrevivehiculo) {
			Optional<RevisionesVehiculoVO> c = rvsi.findById(idrevivehiculo);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/revisiones")
		public ResponseEntity<?> insertar(@RequestBody RevisionesVehiculoVO revisionvehiculo) {
			rvsi.save(revisionvehiculo);
			return ResponseEntity.status(HttpStatus.CREATED).body(revisionvehiculo);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/revisiones/{idruta}")
		public ResponseEntity<?> modificar(@PathVariable int idrevivehiculo, @RequestBody RevisionesVehiculoVO revisionvehiculo) {
			if (rvsi.findById(idrevivehiculo).isPresent()) {
				revisionvehiculo.setIdrevivehiculo(idrevivehiculo);
				rvsi.save(revisionvehiculo);
				return ResponseEntity.ok(revisionvehiculo);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/revisiones/{idruta}")
		public ResponseEntity<?> borrar(@PathVariable int idrevivehiculo) {
			if (rvsi.findById(idrevivehiculo).isPresent()) {
				RevisionesVehiculoVO p = rvsi.findById(idrevivehiculo).get();
				rvsi.deleteById(idrevivehiculo);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

}
