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

import com.dawes.modelos.ZonasVO;
import com.dawes.servicioimpl.ZonasServiceImpl;

@RestController
public class ZonasWS {

	@Autowired
	ZonasServiceImpl zsi;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/zonas")
	public ResponseEntity<?> leerTodos(){
		List<ZonasVO> lista = (List<ZonasVO>) zsi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/zonas/{idzona}")
		public ResponseEntity<?> leerPorId(@PathVariable int idzona) {
			Optional<ZonasVO> c = zsi.findById(idzona);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un ContenedorRuta
		@PostMapping("/zonas")
		public ResponseEntity<?> insertar(@RequestBody ZonasVO zona) {
			zsi.save(zona);
			return ResponseEntity.status(HttpStatus.CREATED).body(zona);
		}
		
		
		
		
		
		
		// Servicio para modificar un ContenedorRuta
		@PutMapping("/zonas/{idzona}")
		public ResponseEntity<?> modificar(@PathVariable int idzona, @RequestBody ZonasVO zona) {
			if (zsi.findById(idzona).isPresent()) {
				zona.setIdzona(idzona);
				zsi.save(zona);
				return ResponseEntity.ok(zona);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un ContenedorRuta
		@DeleteMapping("/zonas/{idzona}")
		public ResponseEntity<?> borrar(@PathVariable int idzona) {
			if (zsi.findById(idzona).isPresent()) {
				ZonasVO p = zsi.findById(idzona).get();
				zsi.deleteById(idzona);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}
	
	
}
