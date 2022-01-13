package com.dawes.crudsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dawes.services.ContenedorService;
import com.dawes.servicioimpl.MyUserDestailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AppSeguridad extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ContenedorService cs;
	
	@Autowired
	MyUserDestailsService uds;
	
	
	// metodo del video de la UPM
	
	// Con este método le digo a Spring que quiero utilizar un servicio de autenticación propio, hecho por mi.
	
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(uds).passwordEncoder(passwordEncoder());
//	}
	
	
	
	// Metodo encriptación
	
	// Aqui le digo a Spring que tipo de encriptador de claves quiero utilizar, en mi caso BCryptPasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	public String encript(String password) {
		return passwordEncoder().encode(password);
	}
	
//	
	//Programar Autenticación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("usuario").password(encript("temporal")).roles("ADMIN");	}
	
	
	
//	//Programar Autenticación
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(uds);
//	}
	
	

	// Programo la autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login/").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/login/").hasAnyRole("USER", "ADMIN");
		http.formLogin().loginPage("/login/");
		http.exceptionHandling().accessDeniedPage("/403");
		http.logout().logoutSuccessUrl("/home/");
		http.csrf().disable();
	}

	//Aqui configuro la parte generica 
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().addFilter(jwtAuthorizationFilter());
//	}
	
//	@Bean
//	public JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
//		return new JwtAuthorizationFilter(this.authenticationManager());
//	}
//	

}
