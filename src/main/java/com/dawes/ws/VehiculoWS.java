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

import com.dawes.modelos.VehiculoVO;
import com.dawes.services.VehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehiculoWS {

	@Autowired
	VehiculoService vs;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculo")
	public ResponseEntity<?> leerTodos() {
		List<VehiculoVO> lista = (List<VehiculoVO>) vs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculopage/{page}")
	public Page<VehiculoVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 3);
		System.out.println(pageable.toString());
		return vs.findAll(pageable);
	}

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculo/{idvehiculo}")
	public ResponseEntity<?> leerPorId(@PathVariable int idvehiculo) {
		Optional<VehiculoVO> c = vs.findById(idvehiculo);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PostMapping("/vehiculo")
	public ResponseEntity<?> insertar(@RequestBody VehiculoVO vehiculo) {
		vs.save(vehiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
	}

	// Servicio para modificar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PutMapping("/vehiculo/{idvehiculo}")
	public ResponseEntity<?> modificar(@PathVariable int idvehiculo, @RequestBody VehiculoVO vehiculo) {
		if (vs.findById(idvehiculo).isPresent()) {
			vehiculo.setIdvehiculo(idvehiculo);
			vs.save(vehiculo);
			return ResponseEntity.ok(vehiculo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/vehiculo/{idvehiculo}")
	public ResponseEntity<?> borrar(@PathVariable int idvehiculo) {
		if (vs.findById(idvehiculo).isPresent()) {
			VehiculoVO p = vs.findById(idvehiculo).get();
			vs.deleteById(idvehiculo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
