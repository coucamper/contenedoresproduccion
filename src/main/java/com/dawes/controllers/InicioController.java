package com.dawes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

	@GetMapping("/inicio")
	public String inicio(Model modelo) {
		return "/inicio";
	}
	
	@GetMapping("/panelentrada")
	public String panelentrada(@RequestParam String usuario, Model modelo) {
		modelo.addAttribute("usuario", usuario);
		return "/panelentrada";
	}
	
	@GetMapping("/usuario")
	public String usuario(@RequestParam String usuario, Model modelo) {
		modelo.addAttribute("usuario", usuario);
		return "/panelentrada";
	}
	
}
