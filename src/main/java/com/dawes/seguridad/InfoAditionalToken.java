package com.dawes.seguridad;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.dawes.modelos.UsuarioVO;
import com.dawes.services.InterfaceUsuarioService;

@Component
public class InfoAditionalToken implements TokenEnhancer {
	
	@Autowired
	InterfaceUsuarioService ius;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UsuarioVO usuario = ius.findByUsername(authentication.getName()); 
		
		Map<String, Object> info = new HashMap<>();
		info.put("nombre_usuario", usuario.getUsername());
		info.put("password_usuario", usuario.getPassword());
		info.put("id_usuario", usuario.getUserid());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
	

	
}
