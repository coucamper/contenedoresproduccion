package com.dawes.ws;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.MensajeVO;
import com.dawes.services.EmpleadoService;
import com.dawes.services.MensajeService;
import com.dawes.services.TipoImportanciaMensajeService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
public class MensajesWS {

	@Autowired
	MensajeService ms;
	
	@Autowired
	EmpleadoService es;
	
	@Autowired
	TipoImportanciaMensajeService tim;

	// Servicio web para consultar todos los proveedores
	@Secured("ROLE_ADMIN")
	@GetMapping("/mensaje")
	public ResponseEntity<?> leerTodos() {
		List<MensajeVO> lista = (List<MensajeVO>) ms.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/mensaje/{idmensaje}")
	public ResponseEntity<?> leerPorId(@PathVariable int idmensaje) {
		Optional<MensajeVO> c = ms.findById(idmensaje);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/mensajereceptor/{idreceptor}")
	public ResponseEntity<?> leerPorIdreceptor(@PathVariable int idreceptor) {
		List<MensajeVO> c = ms.BuscarMensajesPorReceptor(es.findById(idreceptor).get().getIdempleado());
		if (c.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}
	
	
	


	// Servicio para crear un proveedor
	@Secured("ROLE_ADMIN")
	@PostMapping("/mensaje")
	public ResponseEntity<?> insertar(@RequestBody MensajeVO mensaje) {
		ms.save(mensaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/mensajeform/{idreceptor}/{idremitente}/{idtipoimportancia}")
	public ResponseEntity<?> insertarMensa(@PathVariable int idreceptor, @PathVariable int idremitente, @PathVariable int idtipoimportancia, @RequestBody MensajeVO mensajeform) {
		mensajeform.setReceptor(es.findById(idreceptor).get());
		mensajeform.setRemitente(es.findById(idremitente).get());
		mensajeform.setIdtipoimportancia(tim.findById(idtipoimportancia).get().getIdtipoimportancia());			
		ms.save(mensajeform);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeform);
	}
	


	
	// Servicio para modificar un proveedor
	@Secured("ROLE_ADMIN")
	@PutMapping("/mensaje/{idmensaje}")
	public ResponseEntity<?> modificar(@PathVariable int idmensaje, @RequestBody MensajeVO mensaje) {
		if (ms.findById(idmensaje).isPresent()) {
			mensaje.setIdmensaje(idmensaje);
			ms.save(mensaje);
			return ResponseEntity.ok(mensaje);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Servicio para eliminar un proveedor
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/mensaje/{idmensaje}")
	public ResponseEntity<?> borrar(@PathVariable int idmensaje) {
		if (ms.findById(idmensaje).isPresent()) {
			MensajeVO p = ms.findById(idmensaje).get();
			ms.deleteById(idmensaje);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}



}
