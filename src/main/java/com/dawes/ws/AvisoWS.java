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

import com.dawes.modelos.AvisoVO;
import com.dawes.modelos.ConcejoVO;
import com.dawes.services.AvisoService;
import com.dawes.services.EmpleadoService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
public class AvisoWS {
	
	@Autowired
	AvisoService as;
	
	@Autowired
	EmpleadoService es;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/aviso")
	public ResponseEntity<?> leerTodos() {
		List<AvisoVO> lista = (List<AvisoVO>) as.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/concejopage/{page}")
//	public Page<ConcejoVO> leerTodosPageable(@PathVariable Integer page) {
//		Pageable pageable = PageRequest.of(page, 10);
//		System.out.println(pageable.toString());
//		return cs.findAll(pageable);
//	}

	
	
	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/avisopage/{page}")
	public Page<AvisoVO> leerTodosPaginados(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return as.findAll(pageable);
	}
	
	
	

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@GetMapping("/aviso/{idaviso}")
	public ResponseEntity<?> leerPorId(@PathVariable int idaviso) {
		Optional<AvisoVO> c = as.findById(idaviso);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un proveedor
	@Secured("ROLE_ADMIN")
	@PostMapping("/aviso/{idremitente}")
	public ResponseEntity<?> insertar(@PathVariable int idremitente, @RequestBody AvisoVO aviso) {
		aviso.setRemitente(es.findById(idremitente).get());
		as.save(aviso);
		return ResponseEntity.status(HttpStatus.CREATED).body(aviso);
	}

	// Servicio para modificar un proveedor
	@Secured("ROLE_ADMIN")
	@PutMapping("/aviso/{idaviso}")
	public ResponseEntity<?> modificar(@PathVariable int idaviso, @RequestBody AvisoVO aviso) {
		if (as.findById(idaviso).isPresent()) {
			aviso.setIdaviso(idaviso);
			as.save(aviso);
			return ResponseEntity.ok(aviso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un proveedor
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/aviso/{idaviso}")
	public ResponseEntity<?> borrar(@PathVariable int idaviso) {
		if (as.findById(idaviso).isPresent()) {
			AvisoVO p = as.findById(idaviso).get();
			as.deleteById(idaviso);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
