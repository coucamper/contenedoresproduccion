package com.dawes.seguridad;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers(HttpMethod.GET,"/api/login").permitAll()
		.antMatchers(HttpMethod.GET,"/contenedor").permitAll()
//		.antMatchers(HttpMethod.GET,"/mensaje").hasRole("ADMIN")
//		.antMatchers(HttpMethod.GET,"/api/clientes").hasAnyRole("ADMIN", "USER")
//		.antMatchers(HttpMethod.GET,"/api/clientes").hasAnyRole("ADMIN", "USER")
//		.antMatchers(HttpMethod.GET,"/api/clientesEsp").hasAnyRole("ADMIN", "USER")
//		.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER","ADMIN")
//		.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
//		.antMatchers("/api/clientes/**").hasRole("ADMIN")
		.antMatchers("/oauth/token").permitAll()
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
		http.csrf().disable();

	}

	// CONFIGURACIÓN DE CORS PARA EVITAR ERRORES EN EL CLIENTE
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "/*"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-type","Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}
}
