package com.dawes.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.modelos.VehiculoVO;
import com.dawes.servicioimpl.VehiculoServiceImpl;

@RestController
public class VehiculoWS {

	@Autowired
	VehiculoServiceImpl svi;
	

	// Servicio web para consultar todos los proveedores
		@GetMapping("/vehiculosws")
		public ResponseEntity<?> leerTodos(){
			List<VehiculoVO> lista = (List<VehiculoVO>) svi.findAll();
			// Si la lista está vacia debe devolver un error 404
			if(lista.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(lista);
			}
		}
		
		// Servicio para consultar un proveedor en concreto
			@GetMapping("/vehiculows/{idvehiculo}")
			public ResponseEntity<?> leerPorId(@PathVariable int idvehiculo) {
				Optional<VehiculoVO> c = svi.findById(idvehiculo);
				if(c.isPresent()) {
					return ResponseEntity.ok(c);
				}else {
					return ResponseEntity.notFound().build();	
				}
			}
			
			
			// Servicio para crear un ContenedorRuta
			@PostMapping("/vehiculows")
			public ResponseEntity<?> insertar(@RequestBody VehiculoVO vehiculo) {
				svi.save(vehiculo);
				return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
			}
			
			
			
			
			
			
			// Servicio para modificar un ContenedorRuta
			@PutMapping("/vehiculows/{idvehiculo}")
			public ResponseEntity<?> modificar(@PathVariable int idvehiculo, @RequestBody VehiculoVO vehiculo) {
				if (svi.findById(idvehiculo).isPresent()) {
					vehiculo.setIdvehiculo(idvehiculo);
					svi.save(vehiculo);
					return ResponseEntity.ok(vehiculo);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			// Servicio para eliminar un ContenedorRuta
			@DeleteMapping("/vehiculows/{idvehiculo}")
			public ResponseEntity<?> borrar(@PathVariable int idvehiculo) {
				if (svi.findById(idvehiculo).isPresent()) {
					VehiculoVO p = svi.findById(idvehiculo).get();
					svi.deleteById(idvehiculo);
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.notFound().build();
				}			
			}

			
	
	
}
