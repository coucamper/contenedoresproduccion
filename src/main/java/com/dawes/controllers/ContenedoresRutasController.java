package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ContenedorVO;
import com.dawes.modelos.ContenedoresRutasVO;
import com.dawes.repository.ContenedoresRutasRepo;

@Controller
public class ContenedoresRutasController {
	
	@Autowired
	ContenedoresRutasRepo crr;
	
	
	
	@GetMapping("/contenedoresrutas")
	public String contenedoresrutas(Model modelo) {
		modelo.addAttribute("contenedoresrutas", crr.findAll());
		return "/index";
	}
	
	@GetMapping("/insertarcontenedorruta")
	public String insertarcontenedorruta(Model modelo) {
		modelo.addAttribute("contenedorruta", new ContenedoresRutasVO());
		return "/insertarcontenedor";
	}
	
	@GetMapping("/eliminarcontenedorruta")
	public String eliminarcontenedorruta(@RequestParam int idcontenedorruta, Model modelo) {
		crr.deleteById(idcontenedorruta);
		modelo.addAttribute("contenedoresrutas", crr.findAll());
		return "/index";
	}
	
	@GetMapping("/modificarcontenedorruta")
	public String modificarcontenedorruta(@RequestParam int idcontenedorruta, Model modelo) {
		modelo.addAttribute("contenedorruta", crr.findById(idcontenedorruta).get());
		return "/modificarcontenedor";
	}
	
	@PostMapping("/submitcontenedorruta")
	public String submitcontenedorruta(@ModelAttribute ContenedoresRutasVO contenedorruta, Model modelo) {
		crr.save(contenedorruta);
		modelo.addAttribute("contenedoresrutas", crr.findAll());
		return "/index";
	}


}
