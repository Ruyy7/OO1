package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	ClienteDeCorreo juan;
	Carpeta carpeta1,carpeta2,carpeta3;
	Email email1,email2,email3,email4;
	Archivo a1;
	
	@BeforeEach
	void setUp() {
		carpeta1 = new Carpeta("Carpeta1");
		carpeta2 = new Carpeta("Carpeta2");
		carpeta3 = new Carpeta("Carpeta3");
		email1 = new Email("Titulo1", "Cuerpo1");
		email2 = new Email("Titulo2", "Cuerpo2");
		email3 = new Email("Titulo3", "Cuerpo3");
		email4 = new Email("Titulo4", "Cuerpo4");
		a1 = new Archivo ("Archivo1");
		email1.agregarArchivo(a1);
		carpeta1.agregarEmail(email1);
		carpeta2.agregarEmail(email2);
		carpeta3.agregarEmail(email3);
		juan = new ClienteDeCorreo (carpeta1, Arrays.asList(carpeta1,carpeta2,carpeta3));
	}
	
	@Test
	public void testRecibir() {
		carpeta1.agregarEmail(email4);
		assertTrue (carpeta1.getEmails().contains(email4));
	}
	
	@Test
	public void testMover() {
		carpeta1.agregarEmail(email4);
		juan.mover(email4, carpeta1, carpeta2);
		assertFalse (carpeta1.getEmails().contains(email4));
		assertTrue (carpeta2.getEmails().contains(email4));
	}
	
	@Test
	public void testBuscar() {
		assertEquals (email2, juan.buscar("Cuerpo2"));
		assertNull (juan.buscar("Cuerpo5"));
	}
	
	@Test
	public void testEspacioOcupado() {
		assertEquals (74, juan.espacioOcupado());
	}
}
