package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViajeTest {
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
	public void reservarLugarPasajeroTest() {
		p1.setSaldo(1200);
		p2.setSaldo(1199);
		p3.setSaldo(1201);
		p4.setSaldo(1250);
		p5.setSaldo(600);
		v2.registrarPasajero(p1); v2.registrarPasajero(p2); v2.registrarPasajero(p3); v2.registrarPasajero(p4); v4.registrarPasajero(p5);
		assertTrue (v2.getPasajeros().contains(p1));
        assertFalse(v2.getPasajeros().contains(p2));
		assertTrue (v2.getPasajeros().contains(p3));
		assertTrue (v2.getPasajeros().contains(p4));
        assertFalse(v4.getPasajeros().contains(p5));
	}

}
