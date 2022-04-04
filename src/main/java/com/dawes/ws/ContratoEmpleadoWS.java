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

import com.dawes.modelos.ContratoEmpleadoVO;
import com.dawes.services.ContratoEmpleadoService;
import com.dawes.services.EmpleadoService;
import com.dawes.services.TipoContratoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContratoEmpleadoWS {
	
	@Autowired
	ContratoEmpleadoService ces;
	
	@Autowired
	EmpleadoService es;
	
	@Autowired
	TipoContratoService tcs;
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/contratoempleado")
	public ResponseEntity<?> leerTodos() {
		List<ContratoEmpleadoVO> lista = (List<ContratoEmpleadoVO>) ces.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/contratoempleado/{idcontratoempleado}")
	public ResponseEntity<?> leerPorId(@PathVariable int idcontratoempleado) {
		Optional<ContratoEmpleadoVO> c = ces.findById(idcontratoempleado);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/contratoempleado/{idempleado}/{idtipocontrato}")
	public ResponseEntity<?> insertar(@PathVariable int idempleado, @PathVariable int idtipocontrato ) {
		ContratoEmpleadoVO contratoemp = new ContratoEmpleadoVO();
		contratoemp.setEmpleado(es.findById(idempleado).get());
		contratoemp.setTipocontrato(tcs.findById(idtipocontrato).get());
		ces.save(contratoemp);
		return ResponseEntity.status(HttpStatus.CREATED).body(contratoemp);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/contratoempleado/{idcontratoempleado}")
	public ResponseEntity<?> modificar(@PathVariable int idcontratoempleado, @RequestBody ContratoEmpleadoVO contratoempleado) {
		if (ces.findById(idcontratoempleado).isPresent()) {
			contratoempleado.setIdcontratoempleado(idcontratoempleado);
			ces.save(contratoempleado);
			return ResponseEntity.ok(contratoempleado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@Secured("ROLE_ADMIN")
	@DeleteMapping("/contratoempleado/{idcontratoempleado}")
	public ResponseEntity<?> borrar(@PathVariable int idcontratoempleado) {
		if (ces.findById(idcontratoempleado).isPresent()) {
			ContratoEmpleadoVO p = ces.findById(idcontratoempleado).get();
			ces.deleteById(idcontratoempleado);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
