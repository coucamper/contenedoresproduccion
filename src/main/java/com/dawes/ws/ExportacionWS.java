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

import com.dawes.modelos.ExportVO;
import com.dawes.repository.ExportRepo;
import com.dawes.servicioimpl.ExportServicImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ExportacionWS {
	
	@Autowired
	ExportRepo er;
	
	@Autowired
	ExportServicImpl esi;
	
	// Servicio web para consultar todos los proveedores
	@GetMapping("/exportacion")
	public ResponseEntity<?> leerTodos(){
		List<ExportVO> lista = (List<ExportVO>) er.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio para consultar un proveedor en concreto
		@GetMapping("/exportacion/{idexport}")
		public ResponseEntity<?> leerPorId(@PathVariable int idexport) {
			Optional<ExportVO> c = er.findById(idexport);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
		
		// Servicio para crear un proveedor
		@PostMapping("/exportacion")
		public ResponseEntity<?> insertar(@RequestBody ExportVO exportacion) {
			er.save(exportacion);
			return ResponseEntity.status(HttpStatus.CREATED).body(exportacion);
		}
		
		// Servicio para modificar un proveedor
		@PutMapping("/exportacion/{idexport}")
		public ResponseEntity<?> modificar(@PathVariable int idexport, @RequestBody ExportVO exportacion) {
			if (er.findById(idexport).isPresent()) {
				exportacion.setIdexport(idexport);
				er.save(exportacion);
				return ResponseEntity.ok(exportacion);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		// Servicio para eliminar un proveedor
		@DeleteMapping("/exportacion/{idexport}")
		public ResponseEntity<?> borrar(@PathVariable int idexport) {
			if (er.findById(idexport).isPresent()) {
				ExportVO p = er.findById(idexport).get();
				er.deleteById(idexport);
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.notFound().build();
			}			
		}
		
		
		@GetMapping("/pesalocalclientesum/{idcliente}")
		public ResponseEntity<?> sumarPesajesCliente(@PathVariable int idcliente){
			if( esi.findById(idcliente).isPresent()) {
				int c = esi.findById(idcliente).get().getCliente().getIdcliente();
				long pesajessum = esi.sumPesosLocalesPorCliente(c);
				//return ResponseEntity.ok("peso total de la ruta Nº "+idruta+" = " +pesajessum);
				return ResponseEntity.ok(pesajessum);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		
		@GetMapping("/estadopago/{estadoPago}")
		public ResponseEntity<?> estadoPago(@PathVariable String estadoPago){
			Optional<List<ExportVO>> listadoPago = Optional.of(esi.findAllByEstadopago(estadoPago));
			if( listadoPago.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(listadoPago);
			}
		}

		
		/*
		 * 	// Servicio web para consultar todos los proveedores
	// Servicio web para consultar todos los proveedores
	@GetMapping("/exportacion")
	public ResponseEntity<?> leerTodos(){
		List<ExportVO> lista = (List<ExportVO>) er.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
			@GetMapping("/exportacion/{idexport}")
		public ResponseEntity<?> leerPorId(@PathVariable int idexport) {
			Optional<ExportVO> c = er.findById(idexport);
			if(c.isPresent()) {
				return ResponseEntity.ok(c);
			}else {
				return ResponseEntity.notFound().build();	
			}
		}
		
	
	
		 */

	

}
