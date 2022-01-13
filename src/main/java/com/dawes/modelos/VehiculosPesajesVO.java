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
@Table(name="vehiculospesajes")
public class VehiculosPesajesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvehipesaje;
	
	@ManyToOne
	@JoinColumn(name="idvehiculo")
	private VehiculoVO vehiculos;
	
	@ManyToOne
	@JoinColumn(name="idpesaje")
	private PesajeVO pesajes;

}
