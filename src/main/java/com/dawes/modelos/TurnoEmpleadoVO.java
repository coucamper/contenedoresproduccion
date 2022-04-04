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
@Table(name="turnosempleados")
public class TurnoEmpleadoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idturnoempleado;
	
	@ManyToOne
	@JoinColumn(name = "idturno")
	private TurnoVO turno;
	
	@ManyToOne
	@JoinColumn(name = "idempleado")
	private EmpleadoVO empleado;
	
	private LocalDate fechainicioturno;
	
	private LocalDate fechafinturno;
	

}
