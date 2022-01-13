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

import com.dawes.modelos.TipoIncidenciaVO;
import com.dawes.modelos.ZonasVO;
import com.dawes.services.TipoIncidenciaService;

@RestController
public class TipoIncidenciaWS {
	
	@Autowired
	TipoIncidenciaService tis;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/tipoincidencia")
	public ResponseEntity<?> leerTodos(){
		List<TipoIncidenciaVO> lista = (List<TipoIncidenciaVO>) tis.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/tipoincidencia/{idtipoincidencia}")
		public ResponseEntity<?> leerPorId(@PathVariable int idtipoincidencia) {
			Optional<TipoIncidenciaVO> c = tis.findById(idtipoincidencia);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un ContenedorRuta
		@PostMapping("/tipoincidencia")
		public ResponseEntity<?> insertar(@RequestBody TipoIncidenciaVO tipoincidencia) {
			tis.save(tipoincidencia);
			return ResponseEntity.status(HttpStatus.CREATED).body(tipoincidencia);
		}
		
		
		
		
		
		
		// Servicio para modificar un ContenedorRuta
		@PutMapping("/tipoincidencia/{idtipoincidencia}")
		public ResponseEntity<?> modificar(@PathVariable int idtipoincidencia, @RequestBody TipoIncidenciaVO tipoincidencia) {
			if (tis.findById(idtipoincidencia).isPresent()) {
				tipoincidencia.setIdtipoincidencia(idtipoincidencia);
				tis.save(tipoincidencia);
				return ResponseEntity.ok(tipoincidencia);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un ContenedorRuta
		@DeleteMapping("/tipoincidencia/{idtipoincidencia}")
		public ResponseEntity<?> borrar(@PathVariable int idtipoincidencia) {
			if (tis.findById(idtipoincidencia).isPresent()) {
				TipoIncidenciaVO p = tis.findById(idtipoincidencia).get();
				tis.deleteById(idtipoincidencia);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}
	

}
