package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	Sistema system;
	Empleado e1,e2,e3,e4,e5,e6;
	PorHoras ph1,ph2,ph3,ph32,ph4,ph5;
	DePlanta dp1,dp2,dp3,dp4;
	
	@BeforeEach
	void setUp() {
		system = new Sistema();
		e1 = system.registrarEmpleado("Empleado","1",111,LocalDate.of(2002, 9, 6),false,false);
		e2 = system.registrarEmpleado("Empleado","2",222,LocalDate.of(2002, 2, 4),true,false);
		e3 = system.registrarEmpleado("Empleado","3",333,LocalDate.of(2001, 6, 12),false,true);
		e4 = system.registrarEmpleado("Empleado","4",444,LocalDate.of(2003, 11, 20),true,true);
		e5 = system.registrarEmpleado("Empleado","5",555,LocalDate.of(2000, 1, 23),true,true);
		e6 = system.registrarEmpleado("Empleado","6",666,LocalDate.of(2000, 6, 29),false,false);
		
		ph1 = e1.registrarContratoPorHoras(LocalDate.of(2016, 7, 8), LocalDate.of(2019, 7, 8), 5, 6);
		ph2 = e1.registrarContratoPorHoras(LocalDate.of(2022, 7, 8), LocalDate.of(2024, 7, 8), 5, 8);
		ph3 = e5.registrarContratoPorHoras(LocalDate.of(2018, 3, 20), LocalDate.of(2021, 3, 20), 10, 7);
		ph32 = e5.registrarContratoPorHoras(LocalDate.of(2022, 5, 10), LocalDate.of(2023, 5, 10), 15, 6);
		ph4 = e2.registrarContratoPorHoras(LocalDate.of(2012, 10, 17), LocalDate.of(2015, 10, 17), 20, 9);
		dp1 = e2.registrarContratoDePlanta(LocalDate.of(2016, 8, 20), 300, 350, 500);
		ph5 = e3.registrarContratoPorHoras(LocalDate.of(2008, 2, 8), LocalDate.of(2020, 2, 8), 8, 8);
		dp2 = e3.registrarContratoDePlanta(LocalDate.of(2020, 3, 18), 600, 800, 960);
		dp3 = e4.registrarContratoDePlanta(LocalDate.of(2002, 12, 31), 400, 1200, 2000);
		dp4 = e6.registrarContratoDePlanta(LocalDate.of(2023, 9, 8), 6000, 8000, 10000);
	}
	
	@Test 
	public void buscarEmpleadoTest(){
		assertEquals(e1, system.buscarEmpleado(111));
		assertNull(system.buscarEmpleado(888));
	}
	
	@Test
	public void empleadosVencidosTest() {
		assertEquals (1, system.empleadosVencidos().size());
	}
	
	@Test
	public void generarRecibosTest() {
		assertEquals (5,system.generarRecibos().size());
	}
	
	@Test
	public void bajaEmpleadoTest() {
		system.bajaEmpleado(e4);
		assertFalse(system.getEmpleados().contains(e4));
	}
}