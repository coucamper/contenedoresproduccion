package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ContenedorVO;
import com.dawes.modelos.VehiculosPesajesVO;
import com.dawes.repository.VehiculosPesajesRepo;

@Controller
public class VehiculosPesajesController {

	@Autowired
	VehiculosPesajesRepo vpr;
	
	@GetMapping("/vehiculospesajes")
	public String vehiculospesajes(Model modelo) {
		modelo.addAttribute("vehipesajes", vpr.findAll());
		return "/index";
	}
	
	@GetMapping("/insertarvehiculopesaje")
	public String insertarvehiculopesaje(Model modelo) {
		modelo.addAttribute("vehipesaje", new VehiculosPesajesVO());
		return "/insertarvehiculopesaje";
	}
	
	@GetMapping("/eliminarvehiculopesaje")
	public String eliminarvehiculopesaje(@RequestParam int idvehipesaje, Model modelo) {
		vpr.deleteById(idvehipesaje);
		modelo.addAttribute("vehipesaje", vpr.findAll());
		return "/index";
	}
	
	@GetMapping("/modificarvehiculopesaje")
	public String modificarvehiculopesaje(@RequestParam int idvehipesaje, Model modelo) {
		modelo.addAttribute("vehipesaje", vpr.findById(idvehipesaje).get());
		return "/modificarcontenedor";
	}
	
	@PostMapping("/submitvehiculopesaje")
	public String submitvehiculopesaje(@ModelAttribute VehiculosPesajesVO vehipesaje, Model modelo) {
		vpr.save(vehipesaje);
		modelo.addAttribute("vehipesaje", vpr.findAll());
		return "/index";
	}


}
