package com.dawes.modelos;

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
@Table(name="categoriasempleados")
public class CategoriaEmpleadoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcatemple;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO empleado;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private CategoriaVO categoria;
	
	

}
