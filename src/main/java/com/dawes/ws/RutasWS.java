package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.RutaVO;
import com.dawes.services.RutaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RutasWS {

	@Autowired
	RutaService rr;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/ruta")
	public ResponseEntity<?> leerTodos() {
		List<RutaVO> lista = (List<RutaVO>) rr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/rutapage/{page}")
	public Page<RutaVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 3);
		System.out.println(pageable.toString());
		return rr.findAll(pageable);
	}

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@GetMapping("/ruta/{idruta}")
	public ResponseEntity<?> leerPorId(@PathVariable int idruta) {
		Optional<RutaVO> c = rr.findById(idruta);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un proveedor
	@Secured("ROLE_ADMIN")
	@PostMapping("/ruta")
	public ResponseEntity<?> insertar(@RequestBody RutaVO ruta) {
		rr.save(ruta);
		return ResponseEntity.status(HttpStatus.CREATED).body(ruta);
	}

	// Servicio para modificar un proveedor
	@Secured("ROLE_ADMIN")
	@PutMapping("/ruta/{idruta}")
	public ResponseEntity<?> modificar(@PathVariable int idruta, @RequestBody RutaVO ruta) {
		if (rr.findById(idruta).isPresent()) {
			ruta.setIdruta(idruta);
			rr.save(ruta);
			return ResponseEntity.ok(ruta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un proveedor
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/ruta/{idruta}")
	public ResponseEntity<?> borrar(@PathVariable int idruta) {
		if (rr.findById(idruta).isPresent()) {
			RutaVO p = rr.findById(idruta).get();
			rr.deleteById(idruta);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/*
	 * // Servicio web para consultar todos los proveedores
	 * 
	 * @GetMapping("/proveedor") public ResponseEntity<?> leerTodos(){
	 * List<ProveedorVO> lista = (List<ProveedorVO>) pr.findAll(); // Si la lista
	 * está vacia debe devolver un error 404 if(lista.isEmpty()) { return
	 * ResponseEntity.notFound().build(); }else { return ResponseEntity.ok(lista); }
	 * }
	 */

}
