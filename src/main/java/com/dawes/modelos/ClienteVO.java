package com.dawes.modelos;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientesexport")
public class ClienteVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcliente;
	private String razonsoc;
	private String direccion;
	private String telefono;
	private String email;
	private String contacto;
	
	
//	@OneToMany
//	@JoinColumn(name="idclienteexport")
//	private List<ClientesExportacionesVO> cliexportaciones;
	
}
