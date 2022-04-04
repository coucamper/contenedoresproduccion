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
import com.dawes.modelos.EmpleadoVO;
import com.dawes.services.CategoriaService;
import com.dawes.services.EmpleadoService;
import com.dawes.services.TipoContratoService;

//@PreAuthorize("authenticated")
@RestController
@CrossOrigin(origins = {"htpp://localhost:4200", "*"})
public class EmpleadosWS {
	
	@Autowired
	EmpleadoService emr;
	
	@Autowired
	CategoriaService cs;
	
	@Autowired
	TipoContratoService tcs;
	
	
	// Servicio web para consultar todos los empleados
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/empleado")
	public ResponseEntity<?> leerTodos(){
		List<EmpleadoVO> lista = (List<EmpleadoVO>) emr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio web para consultar todos los empleados
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/empleadopage")
	public Page<EmpleadoVO> leerTodospage(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return emr.findAll(pageable);
	}
	

	
	// Servicio web para consultar todos los empleados
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
	@GetMapping("/empleadobynif/{nif}")
	public ResponseEntity<?> leerpornif(@PathVariable String nif){
		EmpleadoVO empleado = emr.findByNif(nif);
		// Si la lista está vacia debe devolver un error 404
		if(empleado == null) {
			return ResponseEntity.notFound().build();
		}else {
			System.out.println(empleado.toString());
			return ResponseEntity.ok(empleado);
		}
	}
	
	// Servicio web para consultar todos los proveedores
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/empleadopage/{page}")
	public Page<EmpleadoVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return emr.findAll(pageable);
	}
	
	// Servicio para consultar un empleado en concreto
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured("ROLE_ADMIN")
		@GetMapping("/empleado/{idempleado}")
		public ResponseEntity<?> leerPorId(@PathVariable int idempleado) {
			Optional<EmpleadoVO> c = emr.findById(idempleado);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un empleado
		@Secured("ROLE_ADMIN")
		@PostMapping("/empleado")
		public ResponseEntity<?> insertar(@RequestBody EmpleadoVO empleado) {
			emr.save(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
		}
		
		
		
		// Servicio para modificar un empleado
		@Secured("ROLE_ADMIN")
		@PutMapping("/empleado/{idempleado}")
		public ResponseEntity<?> modificar(@PathVariable int idempleado, @RequestBody EmpleadoVO empleado) {
			if (emr.findById(idempleado).isPresent()) {
				empleado.setIdempleado(idempleado);
				emr.save(empleado);
				return ResponseEntity.ok(empleado);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		

		
		
		
		// Servicio para eliminar un empleado
		@Secured("ROLE_ADMIN")
		@DeleteMapping("/empleado/{idempleado}")
		public ResponseEntity<?> borrar(@PathVariable int idempleado) {
			if (emr.findById(idempleado).isPresent()) {
				EmpleadoVO p = emr.findById(idempleado).get();
				emr.deleteById(idempleado);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}

		


}
