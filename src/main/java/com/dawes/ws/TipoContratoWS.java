package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dawes.modelos.TipoContratoVO;
import com.dawes.modelos.TipoPermisoVO;
import com.dawes.services.TipoContratoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TipoContratoWS {

	@Autowired
	TipoContratoService tcs;
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/tipocontrato")
	public ResponseEntity<?> leerTodos() {
		List<TipoContratoVO> lista = (List<TipoContratoVO>) tcs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/tipocontrato/{idtipocontrato}")
	public ResponseEntity<?> leerPorId(@PathVariable int idtipocontrato) {
		Optional<TipoContratoVO> c = tcs.findById(idtipocontrato);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/tipocontrato")
	public ResponseEntity<?> insertar(@RequestBody TipoContratoVO tipocontrato) {
		tcs.save(tipocontrato);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipocontrato);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/tipocontrato/{idtipocontrato}")
	public ResponseEntity<?> modificar(@PathVariable int idtipocontrato, @RequestBody TipoContratoVO tipocontrato) {
		if (tcs.findById(idtipocontrato).isPresent()) {
			tipocontrato.setIdtipocontrato(idtipocontrato);
			tcs.save(tipocontrato);
			return ResponseEntity.ok(tipocontrato);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@Secured("ROLE_ADMIN")
	@DeleteMapping("/tipocontrato/{idtipocontrato}")
	public ResponseEntity<?> borrar(@PathVariable int idtipocontrato) {
		if (tcs.findById(idtipocontrato).isPresent()) {
			TipoContratoVO p = tcs.findById(idtipocontrato).get();
			tcs.deleteById(idtipocontrato);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
