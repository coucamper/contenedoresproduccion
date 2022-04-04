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

import com.dawes.modelos.LlenadoContVO;
import com.dawes.services.LlenadoContService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LlenadoContWS {

	@Autowired
	LlenadoContService lcsi;

	@GetMapping("/llenados")
	public ResponseEntity<?> leerTodos() {
		List<LlenadoContVO> lista = (List<LlenadoContVO>) lcsi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@GetMapping("/llenados/{idllenado}")
	public ResponseEntity<?> leerPorId(@PathVariable int idllenado) {
		Optional<LlenadoContVO> c = lcsi.findById(idllenado);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/llenados")
	public ResponseEntity<?> insertar(@RequestBody LlenadoContVO llenado) {
		lcsi.save(llenado);
		return ResponseEntity.status(HttpStatus.CREATED).body(llenado);
	}

	@PutMapping("/llenados/{idllenado}")
	public ResponseEntity<?> modificar(@PathVariable int idllenado, @RequestBody LlenadoContVO llenado) {
		if (lcsi.findById(idllenado).isPresent()) {
			llenado.setIdllenado(idllenado);
			lcsi.save(llenado);
			return ResponseEntity.ok(llenado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/llenados/{idllenado}")
	public ResponseEntity<?> borrar(@PathVariable int idllenado) {
		if (lcsi.findById(idllenado).isPresent()) {
			LlenadoContVO p = lcsi.findById(idllenado).get();
			lcsi.deleteById(idllenado);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
