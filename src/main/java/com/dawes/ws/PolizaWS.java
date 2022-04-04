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

import com.dawes.modelos.ContenedorVO;
import com.dawes.modelos.PolizaVO;
import com.dawes.services.PolizaService;
import com.dawes.services.VehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PolizaWS {

	@Autowired
	PolizaService ps;

	@Autowired
	VehiculoService vs;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/poliza")
	public ResponseEntity<?> leerTodos() {
		List<PolizaVO> lista = (List<PolizaVO>) ps.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio web para consultar todos los proveedores
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/polizapage/{page}")
	public Page<PolizaVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 1);
		System.out.println(pageable.toString());
		return ps.findAll(pageable);
	}

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@GetMapping("/poliza/{idpoliza}")
	public ResponseEntity<?> leerPorId(@PathVariable int idpoliza) {
		Optional<PolizaVO> c = ps.findById(idpoliza);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@GetMapping("/polizav/{idvehiculo}")
	public ResponseEntity<?> leerPorIdVehiculo(@PathVariable int idvehiculo) {
		Optional<PolizaVO> c = ps.BuscarPolizaPorIdVehiculo(vs.findById(idvehiculo).get().getIdvehiculo());
		if (c == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	// Servicio para crear un proveedor
	@Secured("ROLE_ADMIN")
	@PostMapping("/poliza")
	public ResponseEntity<?> insertar(@RequestBody PolizaVO poliza) {
		ps.save(poliza);
		return ResponseEntity.status(HttpStatus.CREATED).body(poliza);
	}

	// Servicio para modificar un proveedor
	@Secured("ROLE_ADMIN")
	@PutMapping("/poliza/{idmulta}")
	public ResponseEntity<?> modificar(@PathVariable int idpoliza, @RequestBody PolizaVO poliza) {
		if (ps.findById(idpoliza).isPresent()) {
			poliza.setIdpoliza(idpoliza);
			ps.save(poliza);
			return ResponseEntity.ok(poliza);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un proveedor
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/poliza/{idmulta}")
	public ResponseEntity<?> borrar(@PathVariable int idpoliza) {
		if (ps.findById(idpoliza).isPresent()) {
			PolizaVO p = ps.findById(idpoliza).get();
			ps.deleteById(idpoliza);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}