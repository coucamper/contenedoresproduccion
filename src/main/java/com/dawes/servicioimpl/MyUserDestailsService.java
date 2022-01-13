package com.dawes.servicioimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.modelos.RolVO;
import com.dawes.modelos.UsuarioVO;
import com.dawes.repository.RolRepo;
import com.dawes.repository.UsuarioRepo;
import com.dawes.repository.UsuarioRolRepo;

@Service
@Transactional
public class MyUserDestailsService implements UserDetailsService {

	@Autowired
	UsuarioRepo ur;
	
	@Autowired
	UsuarioRolRepo urs;
	
	@Autowired
	RolRepo rr;
	
	private User userBuilder(String username, String password, String... roles) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(String role : roles ) {
			authorities.add(new SimpleGrantedAuthority(role="ROLE_"+ role));
		}
		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities );
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioVO usuario = ur.findByUsername(username);

		BCryptPasswordEncoder encoder;

		
		// Se accede a UsuarioVO para recuperar su nombre y claves
		
		if("USER".equals(username)) {
			return this.userBuilder(username, BCryptPasswordEncoder().encode("123456"), "ROLE_USER");
		} else if ("MANAGER".equals(username)){
			return this.userBuilder(username, BCryptPasswordEncoder().encode("123456"), "ROLE_MANAGER");
		} else if("ADMIN".equals(username)) {
			return this.userBuilder(username, BCryptPasswordEncoder().encode("123456"), "ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN");
		} else {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		
       // return new MyUserPrincipal(usuario);
	}
	
	
	private BCryptPasswordEncoder BCryptPasswordEncoder() {
		// TODO Auto-generated method stub
		return null;
	}




}
