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

import com.dawes.modelos.ComarcasRutaVO;
import com.dawes.modelos.ConcejosComarcaVO;
import com.dawes.services.ComarcasRutaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComarcasRutaWS {
	
	@Autowired
	ComarcasRutaService crs;
	
	
	// Servicio web para consultar todos los proveedores
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/comarcasruta")
		public ResponseEntity<?> leerTodos(){
			List<ComarcasRutaVO> lista = (List<ComarcasRutaVO>) crs.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		
		// Servicio para consultar un proveedor en concreto
			@CrossOrigin(origins = "http://localhost:4200")
			@GetMapping("/comarcasruta/{idcomarcaruta}")
			public ResponseEntity<?> leerPorId(@PathVariable int idcomarcaruta) {
				Optional<ComarcasRutaVO> c = crs.findById(idcomarcaruta);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			
			
			// Servicio para crear un ContenedorRuta
			@CrossOrigin(origins = "http://localhost:4200")
			@PostMapping("/comarcasruta")
			public ResponseEntity<?> insertar(@RequestBody ComarcasRutaVO comarcaruta) {
				crs.save(comarcaruta);
				return ResponseEntity.status(HttpStatus.CREATED).body(comarcaruta);
			}
			
			
			
			
			
			
			// Servicio para modificar un ContenedorRuta
			@CrossOrigin(origins = "http://localhost:4200")
			@PutMapping("/comarcasruta/{idcomarcaruta}")
			public ResponseEntity<?> modificar(@PathVariable int idcomarcaruta, @RequestBody ComarcasRutaVO comarcaruta) {
				if (crs.findById(idcomarcaruta).isPresent()) {
					comarcaruta.setIdcomarcaruta(idcomarcaruta);
					crs.save(comarcaruta);
					return ResponseEntity.ok(comarcaruta);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			// Servicio para eliminar un ContenedorRuta
			@CrossOrigin(origins = "http://localhost:4200")
			@DeleteMapping("/comarcasruta/{idcomarcaruta}")
			public ResponseEntity<?> borrar(@PathVariable int idcomarcaruta) {
				if (crs.findById(idcomarcaruta).isPresent()) {
					ComarcasRutaVO p = crs.findById(idcomarcaruta).get();
					crs.deleteById(idcomarcaruta);
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
