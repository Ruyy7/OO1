package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Use en los contratos DePlanta LocalDate.now() para calcular la duracion del contrato
// Hecho el test el Domingo 22 de octubre 2023 (22/10/2023)
public class EmpleadoTest {
	Empleado e1,e2,e3,e4,e5,e6;
	PorHoras ph1,ph2,ph3,ph32,ph4,ph5;
	DePlanta dp1,dp2,dp3,dp4;
	Recibo r1,r2,r3,r4,r5,r6;
	
	@BeforeEach
	void setUp() {
		e1 = new Empleado("Empleado","1",111,LocalDate.of(2002, 9, 6),false,false);
		e2 = new Empleado("Empleado","2",222,LocalDate.of(2002, 2, 4),true,false);
		e3 = new Empleado("Empleado","3",333,LocalDate.of(2001, 6, 12),false,true);
		e4 = new Empleado("Empleado","4",444,LocalDate.of(2003, 11, 20),true,true);
		e5 = new Empleado("Empleado","5",555,LocalDate.of(2000, 1, 23),true,true);
		e6 = new Empleado("Empleado","6",666,LocalDate.of(2000, 6, 29),false,false);
		
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
		
		r1 = e1.generarRecibo();
		r2 = e2.generarRecibo();
		r3 = e3.generarRecibo();
		r4 = e4.generarRecibo();
		r5 = e5.generarRecibo();
		r6 = e6.generarRecibo();
	}
	
	@Test
	public void calcularAntiguedadTest() {
		assertEquals (4, e5.calcularAntiguedad());
		assertEquals(5, e1.calcularAntiguedad());
		assertEquals (10, e2.calcularAntiguedad());
		assertEquals (15, e3.calcularAntiguedad());
		assertEquals (20, e4.calcularAntiguedad());
	}
	
	@Test
	public void calcuclarCobroTest() {
		assertEquals (0, e5.calcularCobro());
		assertEquals (52, e1.calcularCobro());
		assertEquals (975, e2.calcularCobro());
		assertEquals (2652, e3.calcularCobro());
		assertEquals (7200, e4.calcularCobro());
		assertEquals (6000, e6.calcularCobro());
	}
	
	@Test
	public void generarReciboTest() {
		assertNotNull(r1);
		assertNotNull(r2);
		assertNotNull(r3);
		assertNotNull(r4);
		assertNull(r5);
		assertNotNull(r6);
	}
}
