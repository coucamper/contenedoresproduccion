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

import com.dawes.modelos.TipoPermisoNrVO;
import com.dawes.modelos.ZonasVO;
import com.dawes.services.TipoPermisoNrService;

@RestController
public class TipoPermisoNrWS {
	
	@Autowired
	TipoPermisoNrService pnrs;
	
	// Servicio web para consultar todos los proveedores
		@GetMapping("/permisonr")
		public ResponseEntity<?> leerTodos(){
			List<TipoPermisoNrVO> lista = (List<TipoPermisoNrVO>) pnrs.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		
		// Servicio para consultar un proveedor en concreto
			@GetMapping("/permisonr/{idpermisonr}")
			public ResponseEntity<?> leerPorId(@PathVariable int idpermisonr) {
				Optional<TipoPermisoNrVO> c = pnrs.findById(idpermisonr);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			
			
			// Servicio para crear un ContenedorRuta
			@PostMapping("/permisonr")
			public ResponseEntity<?> insertar(@RequestBody TipoPermisoNrVO permisonr) {
				pnrs.save(permisonr);
				return ResponseEntity.status(HttpStatus.CREATED).body(permisonr);
			}
			
			
			
			
			
			
			// Servicio para modificar un ContenedorRuta
			@PutMapping("/permisonr/{idpermisonr}")
			public ResponseEntity<?> modificar(@PathVariable int idpermisonr, @RequestBody TipoPermisoNrVO permisonr) {
				if (pnrs.findById(idpermisonr).isPresent()) {
					permisonr.setIdpermisonr(idpermisonr);
					pnrs.save(permisonr);
					return ResponseEntity.ok(permisonr);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			// Servicio para eliminar un ContenedorRuta
			@DeleteMapping("/permisonr/{idpermisonr}")
			public ResponseEntity<?> borrar(@PathVariable int idpermisonr) {
				if (pnrs.findById(idpermisonr).isPresent()) {
					TipoPermisoNrVO p = pnrs.findById(idpermisonr).get();
					pnrs.deleteById(idpermisonr);
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.notFound().build();
				}			
			}

}
