package com.dawes.modelos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contenedoresrutas")
public class ContenedoresRutasVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontenrutas;

	@ManyToOne
	@JoinColumn(name="idruta")
	private RutaVO ruta;
	
	@ManyToOne
	@JoinColumn(name="idcontenedor")
	private ContenedorVO contenedor;

}
