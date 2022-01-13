package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ClienteVO;
import com.dawes.services.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService cs;
	
	@GetMapping("/clientes")
	public String clientes(Model modelo) {
		modelo.addAttribute("clientes", cs.findAll());
		return "/indexclientes";
	}
	
	@GetMapping("/insertarcliente")
	public String insertarcliente(Model modelo) {
		modelo.addAttribute("cliente", new ClienteVO());
		return "/insertarcliente";
	}
	
	@GetMapping("/eliminarcliente")
	public String eliminarcliente(@RequestParam int idcliente, Model modelo) {
		cs.deleteById(idcliente);
		modelo.addAttribute("clientes", cs.findAll());
		return "/indexclientes";
	}
	
	@GetMapping("/modificarcliente")
	public String modificarcliente(@RequestParam int idcliente, Model modelo) {
		modelo.addAttribute("cliente", cs.findById(idcliente).get());
		return "/modificarcliente";
	}
	
	@PostMapping("/submitcliente")
	public String submitcliente(@ModelAttribute ClienteVO cliente, Model modelo) {
		cs.save(cliente);
		modelo.addAttribute("clientes", cs.findAll());
		return "/indexclientes";
	}
	

}
