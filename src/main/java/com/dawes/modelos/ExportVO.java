package com.dawes.modelos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="exportaciones")
public class ExportVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idexport;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechatrans;
	private String numprecinto;
	private int pesolocal;
	private int pesocliente;
	private String clase;
	private Double preciov;
	private String tipopago;
	private Double importe;
	private String estadopago;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	private ClienteVO cliente;
	
	
}
