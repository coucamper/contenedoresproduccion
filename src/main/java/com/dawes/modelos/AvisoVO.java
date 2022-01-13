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
@Table(name="avisos")
public class AvisoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idaviso;
	
	private String tipoaviso;
	
	private String asunto;
	
	private String detalles;
	
	private LocalDate fechaaviso;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;
	
}
