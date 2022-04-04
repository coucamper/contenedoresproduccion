package com.dawes.ws;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelos.UsuarioVO;
import com.dawes.services.RolService;

import com.dawes.services.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginWS {
	
	
	@Autowired
	UsuarioService us;
	
	@Autowired
	RolService rs;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/login")
    public boolean login(@RequestBody UsuarioVO user) {
        return
          user.getUsername().equals("ADMIN") && user.getPassword().equals("temporal");
    }
	
	
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
	
	
	
	
	
	
//	@GetMapping("/login/{user}/{password}")
//	public ResponseEntity<?> acceso(@PathVariable String user, @PathVariable String password){
//		List<UsuarioRolVO> usurol = (List<UsuarioRolVO>) urs.findAll();
//		if (usurol.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		} else {
//			return ResponseEntity.ok(usurol);
//		}
//	}
	
	/*
	 * 	// Servicio web para consultar todos los proveedores
	@GetMapping("/contenedor")
	public ResponseEntity<?> leerTodos(){
		List<ContenedorVO> lista = (List<ContenedorVO>) cr.findAll();
		// Si la lista está vacia debe devolver un error 404
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	 * 
	 * 
	 * 
	 * 
	 */

}
