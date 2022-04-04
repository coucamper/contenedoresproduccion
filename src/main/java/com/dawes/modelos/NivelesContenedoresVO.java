package com.dawes.modelos;

import java.time.LocalDate;

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
@Table(name="nivelescontenedores")
public class NivelesContenedoresVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnivelcontenedor;
	
	private LocalDate fecharegistro;
	
	@ManyToOne
	@JoinColumn(name="idllenado")
	private LlenadoContVO nivelregistro;
	
	@ManyToOne
	@JoinColumn(name="idcontenedor")
	private ContenedorVO contenedor;
	
	@ManyToOne
	@JoinColumn(name="idpesaje")
	private PesajeVO pesaje;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;

}
