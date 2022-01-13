package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dawes.modelos.PesajeVO;
import com.dawes.services.EmpleadoService;
import com.dawes.services.PesajeService;
import com.dawes.services.RutaService;

@Controller
public class PesajesController {

	@Autowired
	PesajeService ps;
	
	@Autowired
	EmpleadoService es;
	
	@Autowired
	RutaService rs;
	
	@GetMapping("/pesajes")
	public String pesajes(Model modelo) {
		modelo.addAttribute("pesajes", ps.findAll());
		return "/pesajes";
	}
	
	@GetMapping("/insertarpesaje")
	public String insertarpesaje(Model modelo) {
		modelo.addAttribute("pesaje", new PesajeVO());
		modelo.addAttribute("empleados", es.findAll());
		modelo.addAttribute("rutas", rs.findAll());
		return "/insertarpesaje";
	}
	
	/*
	@GetMapping("/eliminarcontenedor")
	public String eliminarcontenedor(@RequestParam int idcontenedor, Model modelo) {
		cs.deleteById(idcontenedor);
		modelo.addAttribute("contenedores", cs.findAll());
		return "/index";
	}
	
	@GetMapping("/modificarcontenedor")
	public String modificarcontenedor(@RequestParam int idcontenedor, Model modelo) {
		modelo.addAttribute("contenedor", cs.findById(idcontenedor).get());
		return "/modificarcontenedor";
	}
	*/
	
	@PostMapping("/submitpesaje")
	public String submitpesaje(@ModelAttribute PesajeVO pesaje, Model modelo) {
		ps.save(pesaje);
		modelo.addAttribute("pesajes", ps.findAll());
		return "/pesajes";
	}

	
	
}
