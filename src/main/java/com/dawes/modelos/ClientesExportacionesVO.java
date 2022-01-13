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
@Table(name="clientesexportaciones")
public class ClientesExportacionesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclienteexport;
	
	@ManyToOne
	@JoinColumn(name = "idexport")
	private ExportVO exportacion;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	private ClienteVO cliente;
	
	

}
