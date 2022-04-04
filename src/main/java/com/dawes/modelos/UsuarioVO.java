package com.dawes.modelos;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class UsuarioVO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	
	@Column(unique=true, length = 20)
	private String username;
	
	@Column(length = 60)
	private String password;

	
	@Column(unique = true)
	private String email;
	
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinTable(name="users_roles", joinColumns= @JoinColumn(name="usuariovo_userid"),
     inverseJoinColumns=@JoinColumn(name="roles_idrol"),
     uniqueConstraints= {@UniqueConstraint(columnNames= {"usuariovo_userid", "roles_idrol"})})
	private List<RolVO> roles;

	private static final long serialVersionUID = 1L; // Siempre requerido si implementamos Serializable
	
}