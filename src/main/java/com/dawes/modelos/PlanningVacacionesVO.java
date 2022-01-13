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
@Table(name="planningvacaciones")
public class PlanningVacacionesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idplanvacaciones;
	
	private String mes;
	
	private String anyo;
	
	private LocalDate finiciovaca;
	
	private LocalDate ffinvaca;
	
	private int diasvacaciones;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;
	
	private int diasconsume;
	
	private int diasconsumidos;
	
	private int diasrestantes;
	
	private String anyoanterior;
	
	private String pendientesanyoanterior;


}
