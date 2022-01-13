package com.dawes.modelos;

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
@Table(name="operarios")
public class OperarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idoperario;
	private String categoria;
	
	@OneToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;
	
	
	
}
