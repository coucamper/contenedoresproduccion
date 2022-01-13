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
@Table(name="mantenimientos")
public class MantenimientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreparacion;
	private String denom;
	private LocalDate fechaop;
	private String operario;
	
	@ManyToOne
	@JoinColumn(name="idcontenedor")
	private ContenedorVO contenedores;
}
