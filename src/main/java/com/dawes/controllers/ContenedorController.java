package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ContenedorVO;
import com.dawes.services.ContenedorService;
import com.dawes.services.PesajeService;



@Controller
public class ContenedorController {

	@Autowired
	ContenedorService cs;
	
	@Autowired
	PesajeService ps;
	
	@GetMapping("/contenedores")
	public String contenedores(Model modelo) {
		modelo.addAttribute("contenedores", cs.findAll());
		return "/index";
	}
	
	@GetMapping("/insertarcontenedor")
	public String insertarcontenedor(Model modelo) {
		modelo.addAttribute("contenedor", new ContenedorVO());
		return "/insertarcontenedor";
	}
	
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
	
	@PostMapping("/submitcontenedor")
	public String submitcontenedor(@ModelAttribute ContenedorVO contenedor, Model modelo) {
		cs.save(contenedor);
		modelo.addAttribute("contenedores", cs.findAll());
		return "/index";
	}


	
}
