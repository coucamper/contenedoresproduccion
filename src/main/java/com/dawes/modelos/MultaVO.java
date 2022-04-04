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
@Table(name="multas")
public class MultaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmulta;
	
	private LocalDate fechamulta;
	private String causamulta;
	private String lugarmulta;
	private Double importe;
	
	@ManyToOne
	@JoinColumn(name="idvehiculo")
	private VehiculoVO vehiculo;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;
	
}
