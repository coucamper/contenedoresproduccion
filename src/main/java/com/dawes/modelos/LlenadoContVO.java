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
@Table(name="llenadoscont")
public class LlenadoContVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idllenado;
	
	private String nivel;
	
	private String denomnivel;
	
	private String detalles;
	
}
