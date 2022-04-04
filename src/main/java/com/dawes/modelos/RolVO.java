package com.dawes.modelos;

import javax.persistence.Column;
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
@Table(name="roles")
public class RolVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idrol;
	
	@Column(unique=true, length = 20)
	private String role;
	
	private static final long serialVersionUID = 1L; // Siempre requerido si implementamos Serializabl
	
}
