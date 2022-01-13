package com.dawes.modelos;



import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name="usuarios")
public class UsuarioVO implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 826634895689883609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
//	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
//	private List<UsuarioRolVO> roles;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private List<UserRole> roless;
	
	@CreatedDate
	private LocalDateTime creadoen;
	
	@Builder.Default
	private LocalDateTime lastpasscreatedin = LocalDateTime.now();
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return roless.stream()
        	.map(ur -> new SimpleGrantedAuthority("ROLE_"+ ur.name())).collect(Collectors.toList());
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	
	public String encripta(String password) {
		BCryptPasswordEncoder encripta = new BCryptPasswordEncoder();
		return encripta.encode(password);
	}
	
	
}
