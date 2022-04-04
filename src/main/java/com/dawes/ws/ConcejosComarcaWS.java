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

import com.dawes.modelos.ConcejosComarcaVO;
import com.dawes.services.ComarcaService;
import com.dawes.services.ConcejosComarcaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConcejosComarcaWS {

	@Autowired
	ConcejosComarcaService ccs;
	
	@Autowired
	ComarcaService cs;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejoscomarca")
	public ResponseEntity<?> leerTodos() {
		List<ConcejosComarcaVO> lista = (List<ConcejosComarcaVO>) ccs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejoscomarca/{idconcecomar}")
	public ResponseEntity<?> leerPorId(@PathVariable int idconcecomar) {
		Optional<ConcejosComarcaVO> c = ccs.findById(idconcecomar);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/concejosporcomarca/{idcomarca}")
	public ResponseEntity<?> leerPorIdcomarca(@PathVariable int idcomarca) {
		List<ConcejosComarcaVO> c = ccs.ConcejosPorComarca(cs.findById(idcomarca).get().getIdcomarca());
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/concejoscomarca")
	public ResponseEntity<?> insertar(@RequestBody ConcejosComarcaVO concejocomarca) {
		ccs.save(concejocomarca);
		return ResponseEntity.status(HttpStatus.CREATED).body(concejocomarca);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/concejoscomarca/{idconcecomar}")
	public ResponseEntity<?> modificar(@PathVariable int idconcecomar, @RequestBody ConcejosComarcaVO concejocomarca) {
		if (ccs.findById(idconcecomar).isPresent()) {
			concejocomarca.setIdconcecomar(idconcecomar);
			ccs.save(concejocomarca);
			return ResponseEntity.ok(concejocomarca);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/concejoscomarca/{idconcecomar}")
	public ResponseEntity<?> borrar(@PathVariable int idconcecomar) {
		if (ccs.findById(idconcecomar).isPresent()) {
			ConcejosComarcaVO p = ccs.findById(idconcecomar).get();
			ccs.deleteById(idconcecomar);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
