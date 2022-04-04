package com.dawes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class ContenedoresApplication implements CommandLineRunner {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(ContenedoresApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		for(int i=0 ; i<4; i++ ) {
			String passwordBCrypt = passwordEncoder.encode(password);
			System.out.println(passwordBCrypt);
		}
	}
}
