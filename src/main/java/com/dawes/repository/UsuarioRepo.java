package com.dawes.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.dawes.modelos.UsuarioVO;


@Repository
public interface UsuarioRepo extends JpaRepository<UsuarioVO,Integer> {
	
	public UsuarioVO findByUsername(String username);


}
