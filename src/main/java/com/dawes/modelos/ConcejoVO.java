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
@Table(name="concejos")
public class ConcejoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idconcejo;
	
	private String denom;

}
