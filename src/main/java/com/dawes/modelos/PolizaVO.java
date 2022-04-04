package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="polizas")
public class PolizaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpoliza;
	
	private String numpoliza;
	private String aseguradora;
	private LocalDate fechapoliza;
	private String modalidad;
	private String franquicia;
	private Double importepoliza;
	private String periodofact;
	
	@OneToOne
	@JoinColumn(name = "idvehiculo")
	private VehiculoVO vehiculo;

}
