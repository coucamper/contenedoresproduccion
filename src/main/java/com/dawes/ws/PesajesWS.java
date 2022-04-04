package com.dawes.ws;

import java.time.LocalDate;
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

import com.dawes.modelos.EmpleadoVO;
import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.RutaVO;
import com.dawes.services.EmpleadoService;
import com.dawes.services.PesajeService;
import com.dawes.services.RutaService;
import com.dawes.services.VehiculoService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
public class PesajesWS {

	@Autowired
	PesajeService pr;
	
	@Autowired
	RutaService rs;
	
	@Autowired
	EmpleadoService es;
	
	
	@Autowired
	VehiculoService vs;

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/pesaje")
	public ResponseEntity<?> leerTodos() {
		List<PesajeVO> lista = (List<PesajeVO>) pr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio web para consultar todos los proveedores
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/pesajepage/{page}")
	public Page<PesajeVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return pr.findAll(pageable);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/pesajebyfecha/{fechainicio}/{fechafin}")
	public ResponseEntity<?> leerTodosByFecha(@PathVariable String fechainicio, @PathVariable String fechafin) {
		LocalDate finicio = LocalDate.parse(fechainicio);
		LocalDate ffin = LocalDate.parse(fechafin);
		List<PesajeVO> lista = (List<PesajeVO>) pr.findByfechapesajeBetween(finicio, ffin);
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
		
	
	
	@GetMapping("/recuperarpesaje/{fecha}/{idruta}/{idoperario}")
	public ResponseEntity<?> recuperarpesaje(@PathVariable String fecha, @PathVariable int idruta, @PathVariable int idoperario){
		PesajeVO pesaje = new PesajeVO();
		RutaVO ruta = rs.findById(idruta).get();
		EmpleadoVO operario = es.findById(idoperario).get();
		LocalDate fechapesaje = LocalDate.parse(fecha);
		pesaje = (PesajeVO) pr.findByFechapesajeAndOperarioAndRuta(fechapesaje, operario, ruta);
		if (pesaje == null) {
			System.out.println(pesaje);
			return ResponseEntity.notFound().build();
		} else {
			System.out.println(pesaje);
			return ResponseEntity.ok(pesaje);
		}

	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/pesaje/{idpesaje}")
	public ResponseEntity<?> leerPorId(@PathVariable int idpesaje) {
		Optional<PesajeVO> c = pr.findById(idpesaje);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PostMapping("/pesaje/{idruta}/{idempleado}")
	public ResponseEntity<?> insertar(@PathVariable Integer idruta, @PathVariable Integer idempleado,  @RequestBody PesajeVO pesaje) {
		pesaje.setOperario(es.findById(idempleado).get());
		pesaje.setRuta(rs.findById(idruta).get());
		pr.save(pesaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(pesaje);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@PutMapping("/pesaje/{idpesaje}")
	public ResponseEntity<?> modificar(@PathVariable int idpesaje, @RequestBody PesajeVO pesaje) {
		if (pr.findById(idpesaje).isPresent()) {
			pesaje.setIdpesaje(idpesaje);
			pr.save(pesaje);
			return ResponseEntity.ok(pesaje);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/pesaje/{idpesaje}")
	public ResponseEntity<?> borrar(@PathVariable int idpesaje) {
		if (pr.findById(idpesaje).isPresent()) {
			PesajeVO p = pr.findById(idpesaje).get();
			pr.deleteById(idpesaje);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//		public long sumar(){
//			
//			if(pr.findById(idpesaje).ruta)
//				
//			long pesajessum = pr.sumPesajes();
//			return pesajessum;
//		}

}
