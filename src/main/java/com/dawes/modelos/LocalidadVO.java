package com.dawes.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="localidades")
public class LocalidadVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlocalidad;
	
	private String denomlocalidad;
	
	
}
