package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	Carpeta carpeta;
	Email email1,email2,email3;
	Archivo a1;
	
	@BeforeEach
	void setUp() {
		email1 = new Email("Titulo", "Cuerpo");
		email2 = new Email ("Titulo2", "Cuerpo2");
		email3 = new Email ("Titulo3", "Cuerpo3");
		carpeta = new Carpeta ("Carpeta", Arrays.asList(email1,email2,email3));
		a1 = new Archivo("Archivo");
		email1.agregarArchivo(a1);
	}
	
	@Test
	public void testAgregaryEliminarEmail() {
		Email email4 = new Email ("Titulo4", "Cuerpo4");
		carpeta.agregarEmail(email4);
		assertTrue(carpeta.getEmails().contains(email4));
		carpeta.eliminarEmail(email1);
		assertFalse(carpeta.getEmails().contains(email1));
	}
	
	@Test
	public void testBuscar() {
		assertEquals (email2, carpeta.buscar("Titulo2"));
		assertNull (carpeta.buscar("Cuerpo4"));
	}
	
	@Test
	public void testTamaño() {
		assertEquals(54,carpeta.tamaño());
	}
}
