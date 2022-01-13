package com.dawes.modelos;

import java.time.LocalDate;

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
@Table(name="incidencias")
public class IncidenciaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idincidencia;
	private LocalDate fechainci;
	private String tipoinci;
	private String gravedad;
	@OneToOne
	@JoinColumn(name="idoperario")
	private OperarioVO operario;
	
	private String estado;
	
}
