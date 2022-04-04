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
@Table(name="mensajes")
public class MensajeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmensaje;
	
	private LocalDateTime fechahora;	
	private String asunto;
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name="idremitente",referencedColumnName="idempleado", insertable=true, updatable=true, nullable = true)
	private EmpleadoVO remitente;
	
	@ManyToOne
	@JoinColumn(name="idreceptor",referencedColumnName="idempleado", insertable=true, updatable=true, nullable = true)
	private EmpleadoVO receptor;
	
//	@ManyToOne
//	@JoinColumn(name="idtipoimportancia")
	private int idtipoimportancia;

}
