package ar.edu.unlp.info.oo1.ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PoolCarTest {
//	Fecha de referencia para las pruebas 4 de Noviembre 2023 (04/11/2023)
	PoolCar system;
	Pasajero p1,p2,p3,p4,p5,p6;
	Conductor c1,c2,c3;
	Vehiculo ve1,ve2,ve3;
	Viaje v1,v2,v3;
	
	@BeforeEach
	void setUp() {
		system = new PoolCar();
		ve1 = new Vehiculo ("Peugeot 208",3,Year.of(2017),3000);
		ve2 = new Vehiculo ("Nissan Kicks",5,Year.of(2019),15000);
		ve3 = new Vehiculo ("BMW 135i",5,Year.of(2018),15000);
		p1 = system.registrarPasajero("Pasajero 1"); 
		p2 = system.registrarPasajero("Pasajero 2"); 
		p3 = system.registrarPasajero("Pasajero 3");  
		p4 = system.registrarPasajero("Pasajero 4"); 
		p5 = system.registrarPasajero("Pasajero 5"); 
		p6 = system.registrarPasajero("Pasajero 6"); 
		c1 = system.registrarConductor("Conductor 1",ve1);
		c2 = system.registrarConductor("Conductor 2",ve2);
		c3 = system.registrarConductor("Conductor 3",ve3);
		v1 = system.registrarViaje(c1,"La Plata", "Chascomus",100,LocalDate.of(2023, 11, 3));
		v2 = system.registrarViaje(c2,"Buenos Aires", "Madgalena",300,LocalDate.of(2023, 11, 3));
		v3 = system.registrarViaje(c3,"Mendoza", "San Carlos de Bariloche",600,LocalDate.of(2023, 11, 1));
	}
	
	@Test
	public void registrarViajeTest() {
		Viaje prueba = system.registrarViaje(c1, "La Plata", "Bahia Blanca", 400, LocalDate.now());
		assertEquals (ve1,prueba.getVehiculo());
	}
	
	@Test
	public void listarUsuariosTest() {
		p3.setSaldo(1000);
	    c3.setSaldo(600);
		p2.setSaldo(500);
		c2.setSaldo(400);
		p1.setSaldo(300);
		c1.setSaldo(250);
		List<Usuario> usuarios = system.usuariosRegistrados();
		assertEquals(p1, usuarios.get(4));
		assertEquals(p2, usuarios.get(2));
		assertEquals(p3, usuarios.get(0));
		assertEquals(c1, usuarios.get(5));
		assertEquals(c2, usuarios.get(3));
		assertEquals(c3, usuarios.get(1));
	}
	
	@Test
	public void listarViajesMañanaTest() {
		List<Viaje> viajes = system.listarViajesMañana();
		assertTrue(viajes.contains(v1));
		assertTrue(viajes.contains(v2));
	}
	
	@Test
	public void procesarViajesMañanaTest() {
		List<Usuario> pasajerosv1 = v1.getPasajeros();
		List<Usuario> pasajerosv2 = v2.getPasajeros();
		p1.setSaldo(100); p2.setSaldo(100); p3.setSaldo(100);
		p4.setSaldo(300); p5.setSaldo(300); p6.setSaldo(300);
		pasajerosv1.add(p1); pasajerosv1.add(p2); pasajerosv1.add(p3);
		pasajerosv2.add(p4); pasajerosv2.add(p5); pasajerosv2.add(p6);
		p2.getViajes().add(v3); p4.getViajes().add(v3);
		system.procesarViajesMañana();
		assertEquals(0,p1.getSaldo());
		assertEquals(500,p2.getSaldo());
		assertEquals(0,p3.getSaldo());
		assertEquals(500,p4.getSaldo());
		assertEquals(0,p5.getSaldo());
		assertEquals(0,p3.getSaldo());
		assertEquals(-97,c1.getSaldo());
		assertEquals(-285,c2.getSaldo());
	}
}
