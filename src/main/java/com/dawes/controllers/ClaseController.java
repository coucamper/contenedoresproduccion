package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ClaseVO;
import com.dawes.services.ClaseService;

@Controller
public class ClaseController {

	@Autowired
	ClaseService cs;
	
	@GetMapping("/clases")
	public String clases(Model modelo) {
		modelo.addAttribute("clases", cs.findAll());
		return "/indexclases";
	}
	
	@GetMapping("/insertarclase")
	public String insertarclase(Model modelo) {
		modelo.addAttribute("clase", new ClaseVO());
		return "/insertarclase";
	}
	
	@GetMapping("/eliminarclase")
	public String eliminarclase(@RequestParam int idclase, Model modelo) {
		cs.deleteById(idclase);
		modelo.addAttribute("clases", cs.findAll());
		return "/indexclases";
	}
	
	@GetMapping("/modificarclase")
	public String modificarclase(@RequestParam int idclase, Model modelo) {
		modelo.addAttribute("contenedor", cs.findById(idclase).get());
		return "/modificarclase";
	}
	
	@PostMapping("/submitclase")
	public String submitclase(@ModelAttribute ClaseVO clase, Model modelo) {
		cs.save(clase);
		modelo.addAttribute("clases", cs.findAll());
		return "/indexclases";
	}
	
}
