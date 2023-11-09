package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
	
	private CuentaCorriente CC;
	private CajaDeAhorro CDA;
	
	@BeforeEach
	void setUp() {
		CC = new CuentaCorriente();
		CDA = new CajaDeAhorro();
	}
	
	@Test
	void testSaldo() {
		assertEquals(0,CC.getSaldo());
		assertEquals(0,CDA.getSaldo());
		CC.depositar(500);
		CDA.depositar(700);
		assertEquals(500,CC.getSaldo());
		assertEquals(686,CDA.getSaldo());
	}
	
	@Test
	void testExtraer() {
		CC.depositar(500);
		CDA.depositar(686);
		assertTrue(CC.extraer(100));
		assertEquals (400,CC.getSaldo());
		assertTrue (CDA.extraer(200));
		assertEquals (468.28, CDA.getSaldo());
		assertFalse (CC.extraer(1000));
		assertFalse (CDA.extraer(476.28));
	}
	
	@Test
	void testTransferencia() {
		CC.depositar(400);
		CDA.depositar(500);
		assertTrue (CC.transferirACuenta(100, CDA));
		assertEquals (300,CC.getSaldo());
		assertEquals (588,CDA.getSaldo());
		assertTrue (CDA.transferirACuenta(100, CC));
		assertEquals (402,CC.getSaldo());
		assertEquals (486,CDA.getSaldo());
		assertFalse (CC.transferirACuenta(403, CDA));
		assertFalse (CDA.transferirACuenta(477, CC));
	}
	
}
