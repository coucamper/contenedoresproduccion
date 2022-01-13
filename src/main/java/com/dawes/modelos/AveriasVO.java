package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="averias")
public class AveriasVO {

	@Id
	@GeneratedValue
	private int idaveria;
	
	private String numfactura;
	
	private String denom;
	
	private String taller;
	
	private String gravedad;
	
	private LocalDate fechaaveria;
	
	private Double importe;
	
	
	@ManyToOne
	@JoinColumn(name="idvehiculo")
	private VehiculoVO vehiculo;
	
	
	
	
}
