package com.dawes.modelos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rutas")
public class RutaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idruta;
	private String denom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaini;
	private String periodo;
	private int localidad;
	private int zona;
}
