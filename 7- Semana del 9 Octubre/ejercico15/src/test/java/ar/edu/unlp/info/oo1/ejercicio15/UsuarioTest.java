package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	Usuario Juan,Matias,Justina,Josefina,Tadeo,Pablo;
	Propiedad propiedad1,propiedad2,propiedad3,propiedad4,propiedad5;
	Reserva r1,r2,r3,r4;
	DateLapse dl1,dl2,dl3,dl4;
	
	@BeforeEach
	void setUp() {
		Juan = new Usuario("Juan","Calle 1",111);
		Matias = new Usuario("Matias","Calle 2",222);
		Justina = new Usuario("Justina","Calle 3",333);
		Josefina = new Usuario("Josefina","Calle 4",444);
		Tadeo = new Usuario("Tadeo","Calle 5",555);
		Pablo = new Usuario("Pablo","Calle 7",777);
		propiedad1 = Juan.registrarPropiedad("p1", "d1", 1, "Calle1");
		propiedad2 = Juan.registrarPropiedad("p2", "d2", 2, "Calle2");
		propiedad3 = Matias.registrarPropiedad("p3", "d3", 3, "Calle3");
		propiedad4 = Justina.registrarPropiedad("p4", "d4", 4, "Calle4");
		dl1 = new DateLapse (LocalDate.of(2002, 9, 6), LocalDate.of(2002, 9, 30));
		dl2 = new DateLapse (LocalDate.of(2002, 5, 6), LocalDate.of(2002, 5, 30));
		dl3 = new DateLapse (LocalDate.of(2002, 9, 14), LocalDate.of(2002, 9, 20));
		dl4 = new DateLapse (LocalDate.of(2004, 2, 8), LocalDate.of(2004, 3, 8));
		r1 = propiedad1.realizarReserva(dl1, Josefina);
		r2 = propiedad1.realizarReserva(dl2, Josefina);
		r3 = propiedad2.realizarReserva(dl3, Tadeo);
		r4 = propiedad3.realizarReserva(dl4, Pablo);
	}
	
	@Test
	public void ingresosTest() {
		DateLapse dl5 = new DateLapse(LocalDate.of(2002, 5, 6), LocalDate.of(2002, 9, 30));
		DateLapse dl6 = new DateLapse(LocalDate.of(2002, 8, 4), LocalDate.of(2002, 9, 6));
		DateLapse dl7 = new DateLapse(LocalDate.of(2002, 9, 30), LocalDate.of(2002, 10, 1));
		DateLapse dl8 = new DateLapse(LocalDate.of(2004, 2, 16), LocalDate.of(2004, 2, 24));
		assertEquals (60,Juan.ingresos(dl5));
		assertEquals (24,Juan.ingresos(dl6));
		assertEquals (24,Juan.ingresos(dl7));
		assertEquals (90,Matias.ingresos(dl8));
		assertEquals (0,Justina.ingresos(dl8));
	}
}
