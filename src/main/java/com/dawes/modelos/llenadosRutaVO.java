package com.dawes.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llenadosruta")
public class llenadosRutaVO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idllenadosruta;
	
	@ManyToOne
	@JoinColumn(name = "idruta")
	private RutaVO ruta;
	
	@ManyToOne
	@JoinColumn(name="idllenado")
	private llenadosRutaVO llenado;
	
	@ManyToOne
	@JoinColumn(name = "idcontenedor")
	private ContenedorVO contenedor;
}
