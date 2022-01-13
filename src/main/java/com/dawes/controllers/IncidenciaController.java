package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dawes.services.IncidenciaService;

@Controller
public class IncidenciaController {

	@Autowired
	IncidenciaService is;
	
	
	@GetMapping("/incidencias")
	public String incidencias(Model modelo) {
		modelo.addAttribute("incidencias", is.findAll());
		return "/incidencias";
	}
}
