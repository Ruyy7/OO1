package ar.edu.unlp.info.oo1.ejercicio19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	Cliente c1,c2,c3;
	Vendedor v1,v2,v3;
	Sistema sistema;
	
	@BeforeEach
	void setUp(){
		sistema = new Sistema();
		
		c1 = sistema.registrarCliente("Matias","Avenida 1 1900");
		c2 = sistema.registrarCliente("Carla","Avenida 19 1900");
		c3 = sistema.registrarCliente("Sofi","Avenida 7 1900");
		v1 = sistema.registrarVendedor("Marcos","Avenida 32 1900");
		v2 = sistema.registrarVendedor ("Clara", "Cordoba 720");
		v3 = sistema.registrarVendedor ("Pablo", "Belgrano 28");
	}
	
	@Test
	public void buscarPersonasTest() {
		assertEquals(c1,sistema.buscarPersona("Matias"));
		assertEquals(c2,sistema.buscarPersona("Carla"));
		assertEquals(c3,sistema.buscarPersona("Sofi"));
		assertEquals(v1,sistema.buscarPersona("Marcos"));
		assertEquals(v2,sistema.buscarPersona("Clara"));
		assertEquals(v3,sistema.buscarPersona("Pablo"));
		assertNull(sistema.buscarPersona("Tadeo"));
	}
}
