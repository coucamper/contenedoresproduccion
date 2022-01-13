package com.dawes;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.services.ContenedorService;
import com.dawes.services.ContenedoresRutaService;
import com.dawes.services.RutaService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContenedoresApplicationTests {
	
	@Autowired
	RutaService rs;
	
	@Autowired
	ContenedorService cs;
	
	@Autowired
	ContenedoresRutaService crs;



}
