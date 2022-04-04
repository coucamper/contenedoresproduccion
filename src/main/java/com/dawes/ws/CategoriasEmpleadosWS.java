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

import com.dawes.modelos.CategoriaEmpleadoVO;
import com.dawes.modelos.CategoriaVO;
import com.dawes.modelos.EmpleadoVO;
import com.dawes.services.CategoriaEmpleadoService;
import com.dawes.services.CategoriaService;
import com.dawes.services.EmpleadoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriasEmpleadosWS {

	@Autowired
	CategoriaEmpleadoService ces;

	@Autowired
	CategoriaService cs;

	@Autowired
	EmpleadoService es;

	@Secured("ROLE_ADMIN")
	@GetMapping("/categoriaempleado")
	public ResponseEntity<?> leerTodos() {
		List<CategoriaEmpleadoVO> lista = (List<CategoriaEmpleadoVO>) ces.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/categoriaempleadopage/{page}")
	public Page<CategoriaEmpleadoVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return ces.findAll(pageable);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/categoriaempleado/{idcatemple}")
	public ResponseEntity<?> leerPorId(@PathVariable int idcatemple) {
		Optional<CategoriaEmpleadoVO> c = ces.findById(idcatemple);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/categoriaempleado")
	public ResponseEntity<?> insertar(@RequestBody CategoriaEmpleadoVO categoriaempleado) {
		ces.save(categoriaempleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaempleado);
	}
	
	


	@Secured("ROLE_ADMIN")
	@PostMapping("/addcategoriaempleado/{idempleado}/{idcategoria}")
	public ResponseEntity<?> asignarcategoria(@PathVariable int idempleado, @PathVariable int idcategoria) {
		CategoriaEmpleadoVO categoria = new CategoriaEmpleadoVO();
		categoria.setCategoria(cs.findById(idcategoria).get());
		categoria.setEmpleado(es.findById(idempleado).get());
		System.out.println(categoria.getEmpleado());
		System.out.println(categoria.getCategoria());
		ces.save(categoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}

	// Servicio para modificar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@PutMapping("/categoriaempleado/{idcatemple}")
	public ResponseEntity<?> modificar(@PathVariable int idcatemple,
			@RequestBody CategoriaEmpleadoVO categoriaempleado) {
		if (ces.findById(idcatemple).isPresent()) {
			categoriaempleado.setIdcatemple(idcatemple);
			ces.save(categoriaempleado);
			return ResponseEntity.ok(categoriaempleado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	

	
	
	
	
	
	
	
	

	// Servicio para eliminar un ContenedorRuta
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/categoriaempleado/{idcatemple}")
	public ResponseEntity<?> borrar(@PathVariable int idcatemple) {
		if (ces.findById(idcatemple).isPresent()) {
			CategoriaEmpleadoVO p = ces.findById(idcatemple).get();
			ces.deleteById(idcatemple);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
