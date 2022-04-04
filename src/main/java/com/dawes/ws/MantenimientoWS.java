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

import com.dawes.modelos.ConcejoVO;
import com.dawes.modelos.MantenimientoVO;
import com.dawes.modelos.VehiculoVO;
import com.dawes.services.MantenimientoService;
import com.dawes.services.VehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MantenimientoWS {

	@Autowired
	MantenimientoService ms;

	@Autowired
	VehiculoService vs;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/mantenimiento")
	public ResponseEntity<?> leerTodos() {
		List<MantenimientoVO> lista = (List<MantenimientoVO>) ms.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/mantenimientopage/{page}")
	public Page<MantenimientoVO> leerTodosPageable(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 1);
		System.out.println(pageable.toString());
		return ms.findAll(pageable);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/mantenimiento/{idmantenimiento}")
	public ResponseEntity<?> leerPorId(@PathVariable int idmantenimiento) {
		Optional<MantenimientoVO> c = ms.findById(idmantenimiento);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/mantenimientov/{idvehiculo}")
	public ResponseEntity<?> leerPorIdVehiculo(@PathVariable int idvehiculo) {
		List<MantenimientoVO> l = ms.BuscarMantenimientosVehiculo(vs.findById(idvehiculo).get().getIdvehiculo());
		if (l.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(l);
		}
	}

	// Servicio para crear un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PostMapping("/mantenimiento")
	public ResponseEntity<?> insertar(@RequestBody MantenimientoVO mantenimiento) {
		ms.save(mantenimiento);
		return ResponseEntity.status(HttpStatus.CREATED).body(mantenimiento);
	}

	// Servicio para crear un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PostMapping("/mantenimientov/{idvehiculo}")
	public ResponseEntity<?> insertarMantenVehiculo(@PathVariable int idvehiculo,
			@RequestBody MantenimientoVO mantenimiento) {
		try {
			mantenimiento.setIdvehiculo(vs.findById(idvehiculo).get());
			ms.save(mantenimiento);
			return ResponseEntity.status(HttpStatus.CREATED).body(mantenimiento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mantenimiento);
		}
	}

	// Servicio para modificar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PutMapping("/mantenimiento/{idmantenimiento}")
	public ResponseEntity<?> modificar(@PathVariable int idmantenimiento, @RequestBody MantenimientoVO mantenimiento) {
		if (ms.findById(idmantenimiento).isPresent()) {
			mantenimiento.setIdmantenimiento(idmantenimiento);
			ms.save(mantenimiento);
			return ResponseEntity.ok(mantenimiento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/mantenimiento/{idmantenimiento}")
	public ResponseEntity<?> borrar(@PathVariable int idmantenimiento) {
		if (ms.findById(idmantenimiento).isPresent()) {
			MantenimientoVO p = ms.findById(idmantenimiento).get();
			ms.deleteById(idmantenimiento);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
