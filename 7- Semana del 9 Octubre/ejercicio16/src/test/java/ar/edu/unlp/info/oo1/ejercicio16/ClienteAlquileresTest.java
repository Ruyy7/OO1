package ar.edu.unlp.info.oo1.ejercicio16;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteAlquileresTest {
	ClienteAlquileres cliente;
	Usuario Juan,Matias,Justina,Josefina;
	Propiedad propiedad1,propiedad2,propiedad3,propiedad4,propiedad5;
	Reserva r1,r2,r3;
	DateLapse dl1,dl2,dl3,dl4;
	Politica p1,p2,p3;
	
//	registrarPropiedad(String nombre, String descripcion, double precioxNoche, String direccion)
	
	@BeforeEach
	void setUp() {
		p1 = new Flexible ();
		p2 = new Moderada ();
		p3 = new Estricta ();
		dl1 = new DateLapse (LocalDate.of(2002, 9, 6), LocalDate.of(2002, 9, 30));
		dl2 = new DateLapse (LocalDate.of(2002, 5, 6), LocalDate.of(2002, 5, 30));
		dl3 = new DateLapse (LocalDate.of(2001, 5, 6), LocalDate.of(2001, 5, 30));
		dl4 = new DateLapse (LocalDate.of(2002, 5, 6), LocalDate.of(2002, 9, 30));
		cliente = new ClienteAlquileres();
		Juan = cliente.registrarUsuario("Juan","Calle 1",111);
		Matias = cliente.registrarUsuario("Matias","Calle 2",222);
		Justina = cliente.registrarUsuario("Justina","Calle 3",333);
		Josefina = cliente.registrarUsuario("Josefina","Calle 4",444);
		propiedad1 = Juan.registrarPropiedad("p1", "d1", 1, "Calle1",p1);
		propiedad2 = Juan.registrarPropiedad("p2", "d2", 2, "Calle2",p3);
		propiedad3 = Matias.registrarPropiedad("p3", "d3", 3, "Calle3",p2);
		propiedad4 = Justina.registrarPropiedad("p4", "d4", 4, "Calle4",p2);
		propiedad5 = Justina.registrarPropiedad("p5", "d5", 5, "Calle5",p1);
		r1 = propiedad1.realizarReserva(dl1, Josefina);
		r2 = propiedad3.realizarReserva(dl2, Josefina);
	}
	
	@Test
	public void reservasUsuarioTest() {
		List<Reserva> reservasJose = cliente.reservasUsuario(Josefina);
		List<Reserva> reservasMati = cliente.reservasUsuario(Matias);
		assertEquals (2,reservasJose.size());
		assertEquals (0,reservasMati.size());
	}
	
	@Test
	public void buscarPropiedadesDisbonibleEnTest() {
		List<Propiedad> disponibles = cliente.buscarPropiedadesDisbonibleEn(dl1);
		assertEquals (4,disponibles.size());
		List<Propiedad> disponibles2 = cliente.buscarPropiedadesDisbonibleEn(dl3);
		assertEquals (5,disponibles2.size());
		List<Propiedad> disponibles3 = cliente.buscarPropiedadesDisbonibleEn(dl4);
		assertEquals (3,disponibles3.size());
	}
}
