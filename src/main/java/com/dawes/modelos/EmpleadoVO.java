package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empleados")
public class EmpleadoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idempleado;
	private String nomemp;
	private String ape1emp;
	private String ape2emp;
	private String nif;
	private String nss;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate antiguedad;
	private String telecontacto;
	private String emailemp;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechanac;
	@Column(unique = true)
	private String iban;
	private String estudios;
	private int numhijos;
	private String domicilio;
	private String categoria;
	private String tipocontrato;


}
