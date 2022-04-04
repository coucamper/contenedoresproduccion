package com.dawes.ws;

import java.util.List;

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

import com.dawes.modelos.NivelesContenedoresVO;
import com.dawes.services.NivelesContenedoresRutaServices;
import com.dawes.services.PesajeService;
import com.dawes.services.RutaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NivelesContenRutaWS {

	@Autowired
	NivelesContenedoresRutaServices ncrs;
	
	@Autowired
	RutaService rs;
	
	@Autowired
	PesajeService ps;

	
	@GetMapping("/nivelescontenruta")
	public ResponseEntity<?> leerTodos() {
		List<NivelesContenedoresVO> lista = (List<NivelesContenedoresVO>) ncrs.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}


	/*
	 * Establece un servicio web que requiere de los parametros "page"(Numero de página) y 
	 * "size"(Número de resultados por página) pasados como parametros en la URL.
	 * Devuelve todos los resultados sin filtrar con formato paginado. 
	 * Este método está funcionando correctamente.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/nivelescontenrutapage/{page}/{size}")
	public Page<NivelesContenedoresVO> leerTodosPageable(@PathVariable Integer page, @PathVariable Integer size ) {
		Pageable pageable = PageRequest.of(page, size);
		System.out.println(pageable.toString());
		return ncrs.findAll(pageable);
	}
	
	
	
	/*
	 * Establece un servicio web que requiere de los parametros "page"(Numero de página) y 
	 * "size"(Número de resultados por página) pasados como parametros en la URL.
	 * 
	 * Este método está funcionando correctamente.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/nivelescontenidrutapage/{idruta}/{page}")
	public List<NivelesContenedoresVO> leerTodosPageable2(@PathVariable Integer idruta, @PathVariable Integer page ) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return ncrs.NivelesContenedoresPorRuta2(idruta, pageable);
	}
	
	
	
	
	@GetMapping("/nivelescontenruta/{idruta}")
	public ResponseEntity<?> leerPorId(@PathVariable int idruta) {
		List<NivelesContenedoresVO> c = ncrs.NivelesContenedoresPorRuta(idruta);
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}
	
	@GetMapping("/nivelespesaje/{idnivelcontenedor}")
	public ResponseEntity<?> leerPorPesaje(@PathVariable Integer idnivelcontenedor){
		List<NivelesContenedoresVO> c = ncrs.NivelesContenedoresPorIdnivelcontenedor(idnivelcontenedor);
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/nivelescontenidrutapage/{idpesaje}/{page}")
//	public Page<NivelesContenedoresVO> leerTodosIdPageable(@PathVariable int idpesaje, @PathVariable Integer page) {
//		int pesaje = ps.findById(idpesaje).get().getIdpesaje();
//		Pageable pageable = PageRequest.of(page, 2);
//		System.out.println(pageable.toString());
//		return (Page<NivelesContenedoresVO>) ncrs.findAllByRuta(pesaje, pageable);
//	}
//	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/nivelescontenidruta/{idnivelcontenedor}/{page}")
	public Page<NivelesContenedoresVO> leerPorIdruta(@PathVariable int idnivelcontenedor, @PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 3);
		System.out.println(pageable.toString());
		return (Page<NivelesContenedoresVO>) ncrs.findAll(pageable);
	}

	
	@PostMapping("/nivelescontenruta")
	public ResponseEntity<?> insertar(@RequestBody NivelesContenedoresVO nivelcontenedorruta) {
		ncrs.save(nivelcontenedorruta);
		return ResponseEntity.status(HttpStatus.CREATED).body(nivelcontenedorruta);
	}

	
	@PutMapping("/nivelescontenruta/{idnivelcontenruta}")
	public ResponseEntity<?> modificar(@PathVariable int idnivelcontenruta, @RequestBody NivelesContenedoresVO nivelcontenedorruta) {
		if (ncrs.findById(idnivelcontenruta).isPresent()) {
			nivelcontenedorruta.setIdnivelcontenedor(idnivelcontenruta);
			ncrs.save(nivelcontenedorruta);
			return ResponseEntity.ok(nivelcontenedorruta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	@DeleteMapping("/nivelescontenruta/{idnivelcontenruta}")
	public ResponseEntity<?> borrar(@PathVariable int idnivelcontenruta) {
		if (ncrs.findById(idnivelcontenruta).isPresent()) {
			NivelesContenedoresVO p = ncrs.findById(idnivelcontenruta).get();
			ncrs.deleteById(idnivelcontenruta);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
