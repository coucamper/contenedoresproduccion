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
@Table(name="permisosretriempleado")
public class PermisosRetribuidosEmpleadoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpermisoempleado;
	
	@ManyToOne
	@JoinColumn(name="idtipopermiso")
	private TipoPermisoVO permisoretri;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private EmpleadoVO idempleado;
	
	

}
