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

import com.dawes.modelos.ComarcaVO;
import com.dawes.modelos.ComarcasRutaVO;
import com.dawes.modelos.ConcejoVO;
import com.dawes.services.ComarcaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ComarcasWS {

	@Autowired
	ComarcaService cs;

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/comarca")
	public ResponseEntity<?> leerTodos() {
		List<ComarcaVO> lista = (List<ComarcaVO>) cs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/comarcapage/{page}")
	public Page<ComarcaVO> leerTodosPageable(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 5);
		System.out.println(pageable.toString());
		return cs.findAll(pageable);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/comarca/{idcomarca}")
	public ResponseEntity<?> leerPorId(@PathVariable int idcomarca) {
		Optional<ComarcaVO> c = cs.findById(idcomarca);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un ContenedorRuta
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PostMapping("/comarca")
	public ResponseEntity<?> insertar(@RequestBody ComarcaVO comarca) {
		cs.save(comarca);
		return ResponseEntity.status(HttpStatus.CREATED).body(comarca);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PutMapping("/comarca/{idcomarca}")
	public ResponseEntity<?> modificar(@PathVariable int idcomarca, @RequestBody ComarcaVO comarcaruta) {
		if (cs.findById(idcomarca).isPresent()) {
			comarcaruta.setIdcomarca(idcomarca);
			cs.save(comarcaruta);
			return ResponseEntity.ok(comarcaruta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/comarca/{idcomarca}")
	public ResponseEntity<?> borrar(@PathVariable int idcomarca) {
		if (cs.findById(idcomarca).isPresent()) {
			ComarcaVO p = cs.findById(idcomarca).get();
			cs.deleteById(idcomarca);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
