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

import com.dawes.modelos.MantenimientoVO;
import com.dawes.modelos.MultaVO;
import com.dawes.modelos.PolizaVO;
import com.dawes.services.MultaService;
import com.dawes.services.VehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MultaWS {

	@Autowired
	MultaService ms;

	@Autowired
	VehiculoService vs;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/multa")
	public ResponseEntity<?> leerTodos() {
		List<MultaVO> lista = (List<MultaVO>) ms.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/multapage/{page}")
	public Page<MultaVO> leerTodosPageable(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return ms.findAll(pageable);
	}
	


	@Secured("ROLE_ADMIN")
	@GetMapping("/multa/{idmulta}")
	public ResponseEntity<?> leerPorId(@PathVariable int idmulta) {
		Optional<MultaVO> c = ms.findById(idmulta);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para consultar un proveedor en concreto
	@Secured("ROLE_ADMIN")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/multav/{idvehiculo}")
	public ResponseEntity<?> leerPorIdVehiculo(@PathVariable int idvehiculo) {
		List<MultaVO> c = ms.BuscarMultasPorVehiculo(vs.findById(idvehiculo).get().getIdvehiculo());
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	// Servicio para crear un proveedor
	@Secured("ROLE_ADMIN")
	@PostMapping("/multa")
	public ResponseEntity<?> insertar(@RequestBody MultaVO multa) {
		ms.save(multa);
		return ResponseEntity.status(HttpStatus.CREATED).body(multa);
	}

	// Servicio para modificar un proveedor
	@Secured("ROLE_ADMIN")
	@PutMapping("/multa/{idmulta}")
	public ResponseEntity<?> modificar(@PathVariable int idmulta, @RequestBody MultaVO multa) {
		if (ms.findById(idmulta).isPresent()) {
			multa.setIdmulta(idmulta);
			ms.save(multa);
			return ResponseEntity.ok(multa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un proveedor
	@DeleteMapping("/multa/{idmulta}")
	public ResponseEntity<?> borrar(@PathVariable int idmulta) {
		if (ms.findById(idmulta).isPresent()) {
			MultaVO p = ms.findById(idmulta).get();
			ms.deleteById(idmulta);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}