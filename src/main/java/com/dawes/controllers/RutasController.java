package com.dawes.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelos.RutaVO;
import com.dawes.services.ContenedoresRutaService;
import com.dawes.services.RutaService;

@Controller
public class RutasController {
	
	@Autowired
	RutaService rs;
	
	@Autowired
	ContenedoresRutaService crs;
	
	
	@GetMapping("/rutas")
	public String rutas(Model modelo) {
		modelo.addAttribute("rutas", rs.findAll());
		return "/rutas";
	}
	
	@GetMapping("/insertaruta")
	public String insertaruta(Model modelo) {
		modelo.addAttribute("insertaruta", new RutaVO());
		return "/insertarruta";
	}
	
	@GetMapping("/eliminaruta")
	public String eliminaruta(@RequestParam int idruta, Model modelo) {
		rs.deleteById(idruta);
		modelo.addAttribute("eliminaruta", rs.findAll());
		return "/rutas";
	}
	
	@GetMapping("/modificaruta")
	public String modificaruta(@RequestParam int idruta, Model modelo) {
		modelo.addAttribute("modificaruta", rs.findById(idruta).get());
		return "/rutas";
	}
	
	@PostMapping("/submitruta")
	public String submitruta(@ModelAttribute RutaVO ruta, Model modelo) {
		rs.save(ruta);
		modelo.addAttribute("rutas", rs.findAll());
		return "/rutas";
	}
	
	@RequestMapping("/verrutas")
	public String verrutas(@RequestParam int idruta, Model modelo) {
		modelo.addAttribute("verruta", rs.findById(idruta).get());
		return "/verruta";
	}
	
	@GetMapping("/contenedoresruta")
	public String contenedoresruta(@RequestParam int idruta, Model modelo) {
		modelo.addAttribute("idruta", crs.BuscarContenedoresRuta(idruta));
		return "/contenedoresruta";
	}
	
/*
	@GetMapping("/recuperaparadas")
	public String recuperaparadas(@RequestParam int idlinea, Model modelo) {
		modelo.addAttribute("lineaparada", sl.buscarParadasLinea(idlinea));
		return "templateslineaparada/mostrarparadaslinea";
	}
	
	*/
	
	@RequestMapping(value = "/kml")
	public void kml(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
	    InputStream is = request.getServletContext().getResourceAsStream("/rutas/DrawARoute.kml");;
	    IOUtils.copy(is, response.getOutputStream());
	}
	

}
