package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	Email correowo;
	Archivo a1 = new Archivo ("4444");
	@BeforeEach
	void setUp() {
		correowo = new Email ("Hola", "Cuerpo de prueba");
	}
	
	@Test
	public void testConstructor() {
		assertTrue(correowo.adjuntos().isEmpty());
	}
	
	@Test
	public void testAgregarArchivo() {
		correowo.agregarArchivo(a1);
		assertFalse(correowo.adjuntos().isEmpty());
	}
	
	@Test
	public void testTamaño() {
		correowo.agregarArchivo(a1);
		assertEquals(24,correowo.tamaño());
	}
	
	@Test
	public void testBuscar() {
		assertTrue (correowo.buscar("Hola"));
		assertTrue (correowo.buscar("Cuerpo de prueba"));
		assertFalse (correowo.buscar("Falso"));
	}
}
