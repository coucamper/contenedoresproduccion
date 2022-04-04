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
@Table(name="contenedores")
public class ContenedorVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontenedor;
	private int zona;
	private int localidad;
	private String barrio;
	private String denom;
	private String ubicacion;
	private String coordenadas;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaimplantacion;
	private String mapa;
}
