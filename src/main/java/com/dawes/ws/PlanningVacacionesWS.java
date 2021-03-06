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
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.MultaVO;
import com.dawes.modelos.PlanningVacacionesVO;
import com.dawes.services.EmpleadoService;
import com.dawes.services.PlanningVacacionesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlanningVacacionesWS {

	@Autowired
	PlanningVacacionesService pvs;

	@Autowired
	EmpleadoService es;

	@GetMapping("/vacacionesws")
	public ResponseEntity<?> leerTodos() {
		List<PlanningVacacionesVO> lista = (List<PlanningVacacionesVO>) pvs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/vacacioneswspage/{page}")
	public Page<PlanningVacacionesVO> leerTodosPageable(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 2);
		System.out.println(pageable.toString());
		return pvs.findAll(pageable);
	}

	@GetMapping("/vacacionesws/{idvacaciones}")
	public ResponseEntity<?> leerPorId(@PathVariable int idvacaciones) {
		Optional<PlanningVacacionesVO> c = pvs.findById(idvacaciones);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/vacacionesempleado/{idempleado}")
	public ResponseEntity<?> leerPorIdempleado(@PathVariable int idempleado) {
		List<PlanningVacacionesVO> c = pvs.BuscarVacacionesEmpleado(es.findById(idempleado).get().getIdempleado());
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	@PostMapping("/vacacionesws")
	public ResponseEntity<?> insertar(@RequestBody PlanningVacacionesVO vacacion) {
		pvs.save(vacacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(vacacion);
	}

	@PutMapping("/vacacionesws/{idvacaciones}")
	public ResponseEntity<?> modificar(@PathVariable int idvacaciones, @RequestBody PlanningVacacionesVO vacacion) {
		if (pvs.findById(idvacaciones).isPresent()) {
			vacacion.setIdplanvacaciones(idvacaciones);
			pvs.save(vacacion);
			return ResponseEntity.ok(vacacion);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/vacacionesws/{idvacaciones}")
	public ResponseEntity<?> borrar(@PathVariable int idvacaciones) {
		if (pvs.findById(idvacaciones).isPresent()) {
			PlanningVacacionesVO p = pvs.findById(idvacaciones).get();
			pvs.deleteById(idvacaciones);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
