package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ContenedorVO;
import com.dawes.modelos.VehiculoVO;
import com.dawes.servicioimpl.VehiculoServiceImpl;

@Controller
public class VehiculoController {

	@Autowired
	VehiculoServiceImpl vsi;
	
	
	@GetMapping("/vehiculos")
	public String vehiculos(Model modelo) {
		modelo.addAttribute("vehiculos", vsi.findAll());
		return "/index";
	}
	
	@GetMapping("/insertarvehiculo")
	public String insertarvehiculo(Model modelo) {
		modelo.addAttribute("vehiculo", new VehiculoVO());
		return "/insertarvehiculo";
	}
	
	@GetMapping("/eliminarvehiculo")
	public String eliminarvehiculo(@RequestParam int idvehiculo, Model modelo) {
		vsi.deleteById(idvehiculo);
		modelo.addAttribute("vehiculos", vsi.findAll());
		return "/index";
	}
	
	@GetMapping("/modificarvehiculo")
	public String modificarvehiculo(@RequestParam int idvehiculo, Model modelo) {
		modelo.addAttribute("vehiculo", vsi.findById(idvehiculo).get());
		return "/modificarcontenedor";
	}
	
	@PostMapping("/submitvehiculo")
	public String submitvehiculo(@ModelAttribute VehiculoVO vehiculo, Model modelo) {
		vsi.save(vehiculo);
		modelo.addAttribute("vehiculos", vsi.findAll());
		return "/index";
	}

	
}
