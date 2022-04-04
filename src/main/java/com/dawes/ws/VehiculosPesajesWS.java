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

import com.dawes.modelos.PesajeVO;
import com.dawes.modelos.VehiculosPesajesVO;
import com.dawes.services.VehiculosPesajesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehiculosPesajesWS {

	@Autowired
	VehiculosPesajesService vpsi;

	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculospesajesws")
	public ResponseEntity<?> leerTodos() {
		List<VehiculosPesajesVO> lista = (List<VehiculosPesajesVO>) vpsi.findAll();
		// Si la lista está vacia debe devolver un error 404
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	// Servicio web para consultar todos los proveedores
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/vehiculospesajeswspage/{page}")
	public Page<VehiculosPesajesVO> leerTodosPage(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		System.out.println(pageable.toString());
		return vpsi.findAll(pageable);
	}

	
	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculospesajesws/{idvehipesaje}")
	public ResponseEntity<?> leerPorId(@PathVariable int idvehipesaje) {
		Optional<VehiculosPesajesVO> c = vpsi.findById(idvehipesaje);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@Secured("ROLE_ADMIN")
	@PostMapping("/vehiculospesajesws")
	public ResponseEntity<?> insertar(@RequestBody VehiculosPesajesVO vehipesaje) {
		vpsi.save(vehipesaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(vehipesaje);
	}

	
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/vehiculospesajesws/{idvehipesaje}")
	public ResponseEntity<?> modificar(@PathVariable int idvehipesaje, @RequestBody VehiculosPesajesVO vehipesaje) {
		if (vpsi.findById(idvehipesaje).isPresent()) {
			vehipesaje.setIdvehipesaje(idvehipesaje);
			vpsi.save(vehipesaje);
			return ResponseEntity.ok(vehipesaje);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/vehiculospesajesws/{idvehipesaje}")
	public ResponseEntity<?> borrar(@PathVariable int idvehipesaje) {
		if (vpsi.findById(idvehipesaje).isPresent()) {
			VehiculosPesajesVO p = vpsi.findById(idvehipesaje).get();
			vpsi.deleteById(idvehipesaje);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/vehiculospesajessum")
	public long sumar() {
		long pesajessum = vpsi.sumPesajes();
		return pesajessum;
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/pesajesrutasum/{idruta}")
	public ResponseEntity<?> sumarPesajesRutas(@PathVariable int idruta) {
		if (vpsi.findById(idruta).isPresent()) {
			int r = vpsi.findById(idruta).get().getPesajes().getRuta().getIdruta();
			long pesajessum = vpsi.sumPesajes(idruta);
			// return ResponseEntity.ok("peso total de la ruta Nº "+idruta+" = "
			// +pesajessum);
			return ResponseEntity.ok(pesajessum);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
