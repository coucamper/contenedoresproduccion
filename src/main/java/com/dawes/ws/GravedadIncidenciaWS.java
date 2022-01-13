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

import com.dawes.modelos.ClienteVO;
import com.dawes.modelos.GravedadIncidenciaVO;
import com.dawes.repository.GravedadIncidenciaRepo;

@RestController
@CrossOrigin(origins = "http://localhos:4200/")
public class GravedadIncidenciaWS {
	
	@Autowired
	GravedadIncidenciaRepo gir;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/gravedad")
	public ResponseEntity<?> leerTodos(){
		List<GravedadIncidenciaVO> lista = (List<GravedadIncidenciaVO>) gir.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/gravedad/{idgravedad}")
		public ResponseEntity<?> leerPorId(@PathVariable int idgravedad) {
			Optional<GravedadIncidenciaVO> c = gir.findById(idgravedad);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/gravedad")
		public ResponseEntity<?> insertar(@RequestBody GravedadIncidenciaVO gravedad) {
			gir.save(gravedad);
			return ResponseEntity.status(HttpStatus.CREATED).body(gravedad);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/gravedad/{idgravedad}")
		public ResponseEntity<?> modificar(@PathVariable int idgravedad, @RequestBody GravedadIncidenciaVO gravedad) {
			if (gir.findById(idgravedad).isPresent()) {
				gravedad.setIdgravedadinci(idgravedad);
				gir.save(gravedad);
				return ResponseEntity.ok(gravedad);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/gravedad/{idclase}")
		public ResponseEntity<?> borrar(@PathVariable int idgravedad) {
			if (gir.findById(idgravedad).isPresent()) {
				GravedadIncidenciaVO p = gir.findById(idgravedad).get();
				gir.deleteById(idgravedad);
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
