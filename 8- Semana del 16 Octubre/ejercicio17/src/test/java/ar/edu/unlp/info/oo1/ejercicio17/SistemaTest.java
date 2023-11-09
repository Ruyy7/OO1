package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	Sistema system;
	int n1,n2,n3;
	Individuo pablo,sofia;
	PersonaJuridica esteban,juan;
	
	@BeforeEach
	void setUp() {
		system = new Sistema();
		n1 = 111; n2 = 222; n3 = 333;
		system.registrarNumero(n1);
		system.registrarNumero(n2);
		system.registrarNumero(n3);
	}
	
	@Test
	public void registrarPersonas() {
		pablo = system.registrarIndividuo("Pablo", "Avenida 1", 111);
		sofia = system.registrarIndividuo("Sofia", "Avenida 7", 222);
		esteban = system.registrarPJ("Esteban", "Avenida 13", 333, "Tipazo");
		juan = system.registrarPJ("Juan", "Avenida 19", 444, "Juan gasolinero");
		
		assertEquals(3,system.getClientes().size());
		assertNull (juan);
	}
}
