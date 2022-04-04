package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dawes.modelos.ConcejosComarcaVO;
import com.dawes.services.ReceptoresAvisoService;
import com.dawes.services.ReceptoresAvisoVO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReceptoresAvisoWS {
	
	@Autowired
	ReceptoresAvisoService ras;
	

		@GetMapping("/receptoresaviso")
		public ResponseEntity<?> leerTodos(){
			List<ReceptoresAvisoVO> lista = (List<ReceptoresAvisoVO>) ras.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		

			@GetMapping("/receptoresaviso/{idrecepcionaviso}")
			public ResponseEntity<?> leerPorId(@PathVariable int idrecepcionaviso) {
				Optional<ReceptoresAvisoVO> c = ras.findById(idrecepcionaviso);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			

			@PostMapping("/receptoresaviso")
			public ResponseEntity<?> insertar(@RequestBody ReceptoresAvisoVO receptoraviso) {
				ras.save(receptoraviso);
				return ResponseEntity.status(HttpStatus.CREATED).body(receptoraviso);
			}
			


			@PutMapping("/receptoresaviso/{idrecepcionaviso}")
			public ResponseEntity<?> modificar(@PathVariable int idrecepcionaviso, @RequestBody ReceptoresAvisoVO receptoraviso) {
				if (ras.findById(idrecepcionaviso).isPresent()) {
					receptoraviso.setIdrecepcionaviso(idrecepcionaviso);
					ras.save(receptoraviso);
					return ResponseEntity.ok(receptoraviso);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			

			@DeleteMapping("/receptoresaviso/{idrecepcionaviso}")
			public ResponseEntity<?> borrar(@PathVariable int idrecepcionaviso) {
				if (ras.findById(idrecepcionaviso).isPresent()) {
					ReceptoresAvisoVO p = ras.findById(idrecepcionaviso).get();
					ras.deleteById(idrecepcionaviso);
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.notFound().build();
				}			
			}



}
