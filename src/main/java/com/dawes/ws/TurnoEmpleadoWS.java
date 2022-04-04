package com.dawes.ws;

import java.time.LocalDate;
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

import com.dawes.modelos.TurnoEmpleadoVO;
import com.dawes.services.EmpleadoService;
import com.dawes.services.TurnoEmpleadoService;
import com.dawes.services.TurnosService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TurnoEmpleadoWS {
	
	@Autowired
	TurnoEmpleadoService tes;
	
	@Autowired
	EmpleadoService es;
	
	@Autowired
	TurnosService ts;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/turnosempleados")
	public ResponseEntity<?> leerTodos() {
		List<TurnoEmpleadoVO> lista = (List<TurnoEmpleadoVO>) tes.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/turnosempleadosbyfecha/{fechainicioturno}/{fechafinturno}")
	public ResponseEntity<?> leerTodosEntrefechas(@PathVariable String fechainicioturno, @PathVariable String fechafinturno) {
		LocalDate finicio = LocalDate.parse(fechainicioturno);
		LocalDate ffin = LocalDate.parse(fechafinturno);
		List<TurnoEmpleadoVO> lista = (List<TurnoEmpleadoVO>) tes.findByfechainicioturnoBetween(finicio, ffin);
		// Si la lista está vacia debe devolver un error 404
		System.out.println(finicio);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			System.out.println(finicio);
			return ResponseEntity.ok(lista);
		}
	}
	
	
	


	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/turnosempleados/{idturnoempleado}")
	public ResponseEntity<?> leerPorId(@PathVariable int idturnoempleado) {
		Optional<TurnoEmpleadoVO> c = tes.findById(idturnoempleado);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PostMapping("/turnosempleados")
	public ResponseEntity<?> insertar(@RequestBody TurnoEmpleadoVO turnoempleado) {
		tes.save(turnoempleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(turnoempleado);
	}
	
	

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PostMapping("/turnosempleados/{idturno}/{idempleado}")
	public ResponseEntity<?> insertarContenedorARuta( @PathVariable int idturno, @PathVariable int idempleado, @RequestBody TurnoEmpleadoVO turnoempleado) {
//		int turno = ts.findById(idturno).get().getIdturno();
//		int empleado = es.findById(idempleado).get().getIdempleado();
		turnoempleado.setTurno(ts.findById(idturno).get());
		turnoempleado.setEmpleado(es.findById(idempleado).get());
		tes.save(turnoempleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(turnoempleado);
	}
	
	


	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PutMapping("/turnosempleados/{idturnoempleado}")
	public ResponseEntity<?> modificar(@PathVariable int idturnoempleado,
			@RequestBody TurnoEmpleadoVO turnoempleado) {
		if (tes.findById(idturnoempleado).isPresent()) {
			turnoempleado.setIdturnoempleado(idturnoempleado);
			tes.save(turnoempleado);
			return ResponseEntity.ok(turnoempleado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/turnosempleados/{idturnoempleado}")
	public ResponseEntity<?> borrar(@PathVariable int idturnoempleado) {
		if (tes.findById(idturnoempleado).isPresent()) {
			TurnoEmpleadoVO p = tes.findById(idturnoempleado).get();
			tes.deleteById(idturnoempleado);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
