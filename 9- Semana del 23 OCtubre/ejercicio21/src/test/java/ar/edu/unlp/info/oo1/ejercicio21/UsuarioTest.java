package ar.edu.unlp.info.oo1.ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
//	Fecha de referencia para las pruebas 4 de Noviembre 2023 (04/11/2023)
	Pasajero p1,p2,p3,p4,p5,p6;
	Conductor c1,c2,c3;
	Viaje v1,v2,v3,v4,v5;
	Vehiculo ve1,ve2,ve3;
	
	@BeforeEach
	void setUp() {
		p1 = new Pasajero ("Pasajero 1"); 
		p2 = new Pasajero ("Pasajero 2"); 
		p3 = new Pasajero ("Pasajero 3"); 
		p4 = new Pasajero ("Pasajero 4");
		p5 = new Pasajero ("Pasajero 5");
		p6 = new Pasajero ("Pasajero 6");
		ve1 = new Vehiculo ("Peugeot 208",3,Year.of(2017),3000);
		ve2 = new Vehiculo ("Nissan Kicks",5,Year.of(2019),15000);
		ve3 = new Vehiculo ("BMW 135i",5,Year.of(2018),15000);
		c1 = new Conductor ("Conductor 1",ve1);
		c2 = new Conductor ("Conductor 2",ve2);
		c3 = new Conductor ("Conductor 3",ve3);
		v1 = new Viaje (c1,"La Plata", "Bahia Blanca",400,LocalDate.of(2023, 10, 4));
		v2 = new Viaje (c2,"Cordoba", "Usuahia",1200,LocalDate.of(2023, 10, 5));
		v3 = new Viaje (c3,"Neuquen", "Chascomus",700,LocalDate.of(2023, 10, 6));
		v4 = new Viaje (c2,"Formosa", "Chacho",400,LocalDate.of(2023, 11, 3));
	}
	
	@Test

	public void cargarSaldoPasajerosTest() {
		p1.getViajes().add(v1);
		p1.cargarSaldo(400);
		assertEquals(360, p1.getSaldo());
		p2.getViajes().add(v2);
		p2.cargarSaldo(400);
		assertEquals(400, p2.getSaldo());
		p3.getViajes().add(v3);
		p3.cargarSaldo(600);
		assertEquals(600,p3.getSaldo());
	}
	
	@Test
	public void cargarSaldoConductorTest() {
		c1.cargarSaldo(500);
		assertEquals (450,c1.getSaldo());
		c2.cargarSaldo(600);
		assertEquals (594,c2.getSaldo());
		c3.cargarSaldo(700);
		assertEquals (630,c3.getSaldo());
	}
	
	@Test
	public void cargarMontoRegaloUsuario() {
		assertEquals (3,c1.cargarMontoRegalo());
		assertEquals (0,p1.cargarMontoRegalo());
		p2.getViajes().add(v2);
		assertEquals (500,p2.cargarMontoRegalo());
	}
	
	@Test
	public void procesarViajeUsuario() {
		p2.getViajes().add(v1);
		p1.setSaldo(1200); 
		p2.setSaldo(1200);
		p1.procesarViaje(v2.getCostoTotal()); 
		p2.procesarViaje(v2.getCostoTotal());
		c2.procesarViaje(v2.getCostoTotal());
		assertEquals (0,p1.getSaldo());
		assertEquals (500,p2.getSaldo());
		assertEquals (-1185,c2.getSaldo());
	}
}
