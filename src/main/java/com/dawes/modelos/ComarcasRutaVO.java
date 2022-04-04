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
@Table(name="comarcasruta")
public class ComarcasRutaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idcomarcaruta;
	
	@ManyToOne
	@JoinColumn(name="idruta")
	private RutaVO ruta;
	
	@ManyToOne
	@JoinColumn(name="idcomarca")
	private ComarcaVO comarca;

}
