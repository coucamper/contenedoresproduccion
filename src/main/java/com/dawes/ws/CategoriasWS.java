package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dawes.modelos.CategoriaVO;
import com.dawes.services.CategoriaService;

@RestController
@CrossOrigin(origins = "htpp://localhost:4200")
public class CategoriasWS {

	@Autowired
	CategoriaService cs;

	// Servicio web para consultar todos los empleados
	@Secured("ROLE_ADMIN")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categoria")
	public ResponseEntity<?> leerTodos() {
		List<CategoriaVO> lista = (List<CategoriaVO>) cs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	// Servicio para consultar un empleado en concreto
	@Secured("ROLE_ADMIN")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categoria/{idcategoria}")
	public ResponseEntity<?> leerPorId(@PathVariable int idcategoria) {
		Optional<CategoriaVO> c = cs.findById(idcategoria);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para crear un empleado
	@Secured("ROLE_ADMIN")
	@PostMapping("/categoria")
	public ResponseEntity<?> insertar(@RequestBody CategoriaVO categoria) {
		cs.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}

	// Servicio para modificar un empleado
	@Secured("ROLE_ADMIN")
	@PutMapping("/categoria/{idcategoria}")
	public ResponseEntity<?> modificar(@PathVariable int idcategoria, @RequestBody CategoriaVO categoria) {
		if (cs.findById(idcategoria).isPresent()) {
			categoria.setIdcategoria(idcategoria);
			cs.save(categoria);
			return ResponseEntity.ok(categoria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un empleado
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/categoria/{idcategoria}")
	public ResponseEntity<?> borrar(@PathVariable int idcategoria) {
		if (cs.findById(idcategoria).isPresent()) {
			CategoriaVO p = cs.findById(idcategoria).get();
			cs.deleteById(idcategoria);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/*
	 * // Servicio web para consultar todos los proveedores
	 * 
	 * @GetMapping("/proveedor") public ResponseEntity<?> leerTodos(){
	 * List<ProveedorVO> lista = (List<ProveedorVO>) pr.findAll(); // Si la lista
	 * está vacia debe devolver un error 404 if(lista.isEmpty()) { return
	 * ResponseEntity.notFound().build(); }else { return ResponseEntity.ok(lista); }
	 * }
	 */

}
