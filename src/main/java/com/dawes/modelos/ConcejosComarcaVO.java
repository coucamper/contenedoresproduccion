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
@Table(name="concejoscomarcas")
public class ConcejosComarcaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idconcecomar;
	
	@ManyToOne
	@JoinColumn(name="idconcejo")
	private ConcejoVO concejo;
	
	@ManyToOne
	@JoinColumn(name="idcomarca")
	private ComarcaVO comarca;
	
}
