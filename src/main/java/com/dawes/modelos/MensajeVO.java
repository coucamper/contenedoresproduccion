package com.dawes.modelos;

import java.time.LocalDateTime;

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
@Table(name = "mensajes")
public class MensajeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmensaje;
	private LocalDateTime hora;
	private String asunto;
	private String contenido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "empleadoid", referencedColumnName="idempleado", insertable=true, updatable=true, nullable = true)
	private EmpleadoVO remitente;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "receptorid", referencedColumnName="idempleado", insertable=false, updatable=false, nullable = true)
	private EmpleadoVO receptor;
	
	private String importancia;
	

	/*
	 * @ManyToOne(optional=false)
@JoinColumn(name="productId",referencedColumnName="id_product", insertable=false, updatable=false)
private Product product;
	 */
}
