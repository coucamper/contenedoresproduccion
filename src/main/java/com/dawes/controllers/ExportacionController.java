package com.dawes.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.ClienteVO;
import com.dawes.modelos.ExportVO;
import com.dawes.services.ClaseService;
import com.dawes.services.ClienteService;
import com.dawes.services.ClientesExportacionesService;
import com.dawes.services.ExportacionService;

@Controller
public class ExportacionController {


	@Autowired
	ExportacionService es;
	
	@Autowired
	ClienteService cs;
	
	@Autowired
	ClientesExportacionesService ces;
	
	@Autowired
	ClaseService css;
	
	
//
//	
//	@GetMapping("/exportacion")
//	public String exportacion() {
//		return "/exportacion";
//	}
//	
//
//	
	
	@GetMapping("/exportaciones")
	public String exportaciones(Model modelo) {
		modelo.addAttribute("exportaciones", es.findAll());
		return "/exportaciones";
	}
	
	@GetMapping("/insertaexportacion")
	public String insertaexportacion(Model modelo) {
		modelo.addAttribute("insertaexportacion", new ExportVO());
		modelo.addAttribute("clientes", cs.findAll());
		modelo.addAttribute("clase", css.findAll());
		return "/insertarcarga";
	}
	
	@GetMapping("/salvacarga")
	public String salvacarga(Model modelo, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechatrans) {
		modelo.addAttribute("salvacarga", new ExportVO());
		modelo.addAttribute("clientes", ces.findAll());
		modelo.addAttribute("clase", css.findAll());
		modelo.addAttribute("fechatrans", fechatrans);
		return "/exportaciones";
	}
	
	@GetMapping("/eliminarexportacion")
	public String eliminarexportacion(@RequestParam int idexportacion, Model modelo) {
		es.deleteById(idexportacion);
		modelo.addAttribute("eliminaexportacion", es.findAll());
		return "/exportaciones";
	}
	
	@GetMapping("/modificarexportacion")
	public String modificarexportacion(@RequestParam int idexport, Model modelo) {
		modelo.addAttribute("modificarexportacion", es.findById(idexport).get());
		return "/exportaciones";
	}
	
	@PostMapping("/submitexportacion")
	public String submitexportacion(@ModelAttribute ExportVO exportacion, @ModelAttribute ClienteVO cliente, Model modelo) {
		es.save(exportacion);
		modelo.addAttribute("exportaciones", es.findAll());
		modelo.addAttribute("clientes", ces.findAll());
		modelo.addAttribute("cliente", exportacion.getIdexport());
		modelo.addAttribute("razonsoc", cliente.getRazonsoc());
		modelo.addAttribute("clase", css.findAll());
		return "/exportaciones";
	}
	
	/*

	@GetMapping("/clientes")
	public String clientes(Model modelo) {
		List<ClienteVO> clientes = (List<ClienteVO>) cs.findAll();
		modelo.addAttribute("clientes", clientes);
		return "clientes";
	}
	
*/
	
}
