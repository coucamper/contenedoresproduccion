package com.dawes.servicioimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.repository.UsuarioRepo;
import com.dawes.services.UserDetailService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    UsuarioRepo usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return (UserDetails) usuarioRepository.findByUsername(username);
	}
	


}
