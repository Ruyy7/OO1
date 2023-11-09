package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	Usuario Juan,Matias,Justina,Josefina,Tadeo,Pablo,Martina;
	Propiedad propiedad1,propiedad2,propiedad3,propiedad4;
	Reserva r1,r2,r3,r4;
	DateLapse dl1,dl2,dl3,dl4,dl5,dl6,dl7,dl8;
	Politica p1,p2,p3;
	
	@BeforeEach
	void setUp(){
		p1 = new Flexible ();
		p2 = new Moderada ();
		p3 = new Estricta ();
		Juan = new Usuario("Juan","Calle 1",111);
		Matias = new Usuario("Matias","Calle 2",222);
		Justina = new Usuario("Justina","Calle 3",333);
		Josefina = new Usuario("Josefina","Calle 4",444);
		Tadeo = new Usuario("Tadeo","Calle 5",555);
		Pablo = new Usuario("Pablo","Calle 7",777);
		Martina = new Usuario ("Martina","Calle 8",888);
		propiedad1 = new Propiedad("p1","d1",1,"Calle1",p1);
		propiedad2 = new Propiedad("p2", "d2", 2, "Calle2",p3);
		propiedad3 = new Propiedad ("p3", "d3", 3, "Calle3",p2);
		propiedad4 = new Propiedad ("p4", "d4", 4, "Calle4",p2);
		dl1 = new DateLapse (LocalDate.of(2002, 9, 6), LocalDate.of(2002, 9, 30));
		dl2 = new DateLapse (LocalDate.of(2002, 5, 6), LocalDate.of(2002, 5, 30));
		dl3 = new DateLapse (LocalDate.of(2002, 9, 14), LocalDate.of(2002, 9, 20));
		dl4 = new DateLapse (LocalDate.of(2004, 2, 8), LocalDate.of(2004, 3, 8));
		dl5 = new DateLapse(LocalDate.of(2002, 9, 30), LocalDate.of(2002, 10, 1));
		dl6 = new DateLapse(LocalDate.of(2002, 9, 2), LocalDate.of(2002, 9, 14));
		dl7 = new DateLapse(LocalDate.of(2002, 9, 15), LocalDate.of(2002, 9, 16));
		dl8 = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 16));
		r1 = propiedad1.realizarReserva(dl1, Josefina);
		r2 = propiedad1.realizarReserva(dl2, Josefina);
		r3 = propiedad2.realizarReserva(dl3, Tadeo);
		r4 = propiedad3.realizarReserva(dl4, Pablo);
	}
	
	
	@Test
	public void estaDisponibleTest() {
		assertTrue(propiedad4.estaDisponibleEn(dl1));
		assertTrue(propiedad3.estaDisponibleEn(dl3));
		assertFalse(propiedad1.estaDisponibleEn(dl1));
		assertFalse (propiedad1.estaDisponibleEn(dl5));
		assertFalse (propiedad2.estaDisponibleEn(dl6));
		assertFalse (propiedad2.estaDisponibleEn(dl7));
	}
	
	@Test
	public void realizarReservaTest() {
		propiedad1.realizarReserva(dl5, Martina);
		assertTrue(propiedad1.getReservas().stream().noneMatch(r -> r.getInquilino().equals(Martina)));
		propiedad1.realizarReserva(dl4, Martina);
		assertTrue(propiedad1.getReservas().stream().anyMatch(r -> r.getInquilino().equals(Martina)));
	}
	
	@Test
	public void eliminarReserva() {
		propiedad1.eliminarReserva(r1);
		assertFalse(propiedad1.getReservas().contains(r1));
		Reserva r5 = propiedad1.realizarReserva(dl8, Josefina);
		assertTrue(propiedad1.getReservas().contains(r5));
	}
	
	@Test
	public void rembolsoTest() {
		assertEquals (0,propiedad2.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 5)));
		assertEquals (24,propiedad1.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 5)));
		assertEquals (12,propiedad3.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 5)));
		assertEquals (12,propiedad3.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 4)));
		assertEquals (24,propiedad3.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 3)));
		assertEquals (0,propiedad1.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 6)));
		assertEquals (0,propiedad1.getPolitica().calcularMonto(r1, LocalDate.of(2002, 9, 30)));
	}
}
