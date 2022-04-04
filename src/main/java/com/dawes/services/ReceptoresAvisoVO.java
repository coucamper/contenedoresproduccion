package com.dawes.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dawes.modelos.AvisoVO;
import com.dawes.modelos.EmpleadoVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="receptoresavisos")
public class ReceptoresAvisoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecepcionaviso;
	
	@ManyToOne
	@JoinColumn(name="idaviso")
	private AvisoVO aviso;
	
	@ManyToOne
	@JoinColumn(name = "idempleado")
	private EmpleadoVO empleado;

}
