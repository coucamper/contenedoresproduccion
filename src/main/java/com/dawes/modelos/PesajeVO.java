package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pesajes")
public class PesajeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpesaje;
	
	@ManyToOne
	@JoinColumn(name="idruta")
	private RutaVO ruta;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechapesaje;
	private float pesaje;
	private String comprobante;
	
	@ManyToOne
	@JoinColumn(name="idoperario")
	private OperarioVO operario;
	
}
