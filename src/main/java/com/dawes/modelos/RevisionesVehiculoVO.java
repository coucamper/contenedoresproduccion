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
@Table(name="revisionesvehiculos")
public class RevisionesVehiculoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrevivehiculo;
	
	private Double numfactura;
	
	private LocalDate fecharevision;
	
	private String tiporevision;
	
	private String detalles;
	
	private String proveedor;
		
	private Double coste;

	
	@ManyToOne
	@JoinColumn(name="idvehiculo")
	private VehiculoVO vehiculo;

}
