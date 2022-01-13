package com.dawes.crudsecurity.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

	public static void main(String[] args) {
		BCryptPasswordEncoder encript = new BCryptPasswordEncoder();
		System.out.println("temporal encriptado es: "+encript.encode("temporal"));
	}

}
