package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehiculos")
public class VehiculoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvehiculo;
	
	private String matricula;
	private String marca;
	private String modelo;
	private LocalDate fechacompra;
	private String poliza;
	private String aseguradora;
	private double kilometros;
	

}
