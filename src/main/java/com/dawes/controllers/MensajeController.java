package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.MensajeVO;
import com.dawes.services.MensajeService;


@Controller
public class MensajeController {
	
	@Autowired
	MensajeService ms;

	
	@GetMapping("/mensajes")
	public String mensajes(Model modelo) {
		modelo.addAttribute("mensajes", ms.findAll());
		return "/panelentrada";
	}	
	
	@GetMapping("/mensajec")
	public String mensaje(@RequestParam int idmensaje, Model modelo) {
		modelo.addAttribute("mensaje", ms.findById(idmensaje).get());
		return "/fichamensaje";
	}
	
	@GetMapping("/insertarmensaje")
	public String insertarmensaje(Model modelo) {
		modelo.addAttribute("insertarmensaje", new MensajeVO());
		return "/mensajeinsertar";
	}
	
	@GetMapping("/eliminarmensaje")
	public String eliminarmensaje(@RequestParam int idmensaje, Model modelo) {
		ms.deleteById(idmensaje);
		modelo.addAttribute("mensajeeliminar", ms.findAll());
		return "/mensajes";
	}
	
	@GetMapping("/modificarmensaje")
	public String modificarmensaje(@RequestParam int idmensaje, Model modelo) {
		modelo.addAttribute("modificarmensaje", ms.findById(idmensaje).get());
		return "/modificamensaje";
	}
	
	@PostMapping("/submitmensaje")
	public String submitmensaje(@ModelAttribute MensajeVO mensaje, Model modelo) {
		ms.save(mensaje);
		modelo.addAttribute("mensajes", ms.findAll());
		return "/panelentrada";
	}

}
