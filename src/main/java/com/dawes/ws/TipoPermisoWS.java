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

import com.dawes.modelos.TipoPermisoVO;
import com.dawes.modelos.ZonasVO;
import com.dawes.services.TipoPermisoService;

@RestController
public class TipoPermisoWS {
	
	@Autowired
	TipoPermisoService tps;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/permiso")
	public ResponseEntity<?> leerTodos(){
		List<TipoPermisoVO> lista = (List<TipoPermisoVO>) tps.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/permiso/{idpermiso}")
		public ResponseEntity<?> leerPorId(@PathVariable int idpermiso) {
			Optional<TipoPermisoVO> c = tps.findById(idpermiso);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un ContenedorRuta
		@PostMapping("/permiso")
		public ResponseEntity<?> insertar(@RequestBody TipoPermisoVO permiso) {
			tps.save(permiso);
			return ResponseEntity.status(HttpStatus.CREATED).body(permiso);
		}
		
		
		
		
		
		
		// Servicio para modificar un ContenedorRuta
		@PutMapping("/permiso/{idpermiso}")
		public ResponseEntity<?> modificar(@PathVariable int idpermiso, @RequestBody TipoPermisoVO permiso) {
			if (tps.findById(idpermiso).isPresent()) {
				permiso.setIdtipopermiso(idpermiso);
				tps.save(permiso);
				return ResponseEntity.ok(permiso);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un ContenedorRuta
		@DeleteMapping("/permiso/{idpermiso}")
		public ResponseEntity<?> borrar(@PathVariable int idpermiso) {
			if (tps.findById(idpermiso).isPresent()) {
				TipoPermisoVO p = tps.findById(idpermiso).get();
				tps.deleteById(idpermiso);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}
	

}
