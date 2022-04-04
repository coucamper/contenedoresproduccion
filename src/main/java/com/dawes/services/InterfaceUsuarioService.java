package com.dawes.services;

import com.dawes.modelos.UsuarioVO;


public interface InterfaceUsuarioService {

	public UsuarioVO findByUsername(String username);
	
}
