package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.dawes.modelos.ConcejoVO;
import com.dawes.services.ConcejoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConcejosWS {

	@Autowired
	ConcejoService cs;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejopage/{page}")
	public Page<ConcejoVO> leerTodosPageable(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return cs.findAll(pageable);
	}

	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejo")
	public ResponseEntity<?> leerTodos() {
		List<ConcejoVO> lista = (List<ConcejoVO>) cs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejo/{idconcejo}")
	public ResponseEntity<?> leerPorId(@PathVariable int idconcejo) {
		Optional<ConcejoVO> c = cs.findById(idconcejo);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un ContenedorRuta
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/concejo")
	public ResponseEntity<?> insertar(@RequestBody ConcejoVO concejo) {
		cs.save(concejo);
		return ResponseEntity.status(HttpStatus.CREATED).body(concejo);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/concejo/{idconcejo}")
	public ResponseEntity<?> modificar(@PathVariable int idconcejo, @RequestBody ConcejoVO concejo) {
		if (cs.findById(idconcejo).isPresent()) {
			concejo.setIdconcejo(idconcejo);
			cs.save(concejo);
			return ResponseEntity.ok(concejo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/concejo/{idconcejo}")
	public ResponseEntity<?> borrar(@PathVariable int idconcejo) {
		if (cs.findById(idconcejo).isPresent()) {
			ConcejoVO p = cs.findById(idconcejo).get();
			cs.deleteById(idconcejo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	
}
