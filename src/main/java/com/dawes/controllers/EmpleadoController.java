package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.EmpleadoVO;
import com.dawes.services.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	EmpleadoService es;
	
	@GetMapping("/empleados")
	public String empleados(Model modelo) {
		modelo.addAttribute("empleados", es.findAll());
		return "/empleados";
	}
	
	@GetMapping("/empleadoc")
	public String empleado(@RequestParam int idempleado, Model modelo) {
		modelo.addAttribute("empleado", es.findById(idempleado).get());
		return "/fichaempleado";
	}
	
	@RequestMapping("/insertarempleado")
	public String insertarempleado(Model modelo) {
		modelo.addAttribute("empleado", new EmpleadoVO());
		return "/empleadoinsertar";
	}
	
	@GetMapping("/eliminarempleado")
	public String eliminarempleado(@RequestParam int idempleado, Model modelo) {
		es.deleteById(idempleado);
		modelo.addAttribute("empleadoeliminar", es.findAll());
		return "/empleados";
	}
	
	@GetMapping("/modificarempleado")
	public String modificarempleado(@RequestParam int idempleado, Model modelo) {
		modelo.addAttribute("empleadomodificar", es.findById(idempleado).get());
		return "/modificaempleado";
	}
	
	@RequestMapping("/submitempleado")
	public String submitempleado(@ModelAttribute EmpleadoVO empleado, Model modelo) {
		es.save(empleado);
		modelo.addAttribute("empleados", es.findAll());
		return "/empleados";
	}
	
	@GetMapping("/vacaciones")
	public String vacaciones(Model modelo) {
		return "/vacaciones";
	}
	

	
}
