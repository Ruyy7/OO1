package ar.edu.unlp.info.oo1.ejercicio20;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FarolaTest {
	private Farola f1,f2,f3;
	
	@BeforeEach
	void setUp(){
		f1 = new Farola("Farolas Corp.",4);
		f2 = new Farola("Farolas Corp.",3);
		f3 = new Farola("Farolas Corp.",2);
	}
	
	@Test
	public void pairWithNeighborTest() {
		f1.pairWithNeighbor(f2);
		f1.pairWithNeighbor(f3);
		assertTrue(f1.getNeighbors().contains(f2));
		assertTrue(f1.getNeighbors().contains(f3));
		assertTrue(f2.getNeighbors().contains(f1));
		assertTrue(f3.getNeighbors().contains(f1));
	}
	
	@Test
	public void ciclosTest() {
		f1.pairWithNeighbor(f2);
		f1.pairWithNeighbor(f3);
		f1.turnOn();
		f1.turnOff();
		f1.turnOn();
		assertTrue(f3.estaVencida());
		f1.turnOff();
		f1.turnOn();
		assertTrue(f2.estaVencida());
	}
	
	@Test
	public void farolasConFocosVencidosTest() {
		f1.pairWithNeighbor(f2);
		f1.pairWithNeighbor(f3);
		f1.turnOn();
		f1.turnOff();
		f1.turnOn();
		f1.turnOff();
		assertTrue(f1.farolasConFocosVencidos().contains(f3));
		f1.turnOn();
		f1.turnOff();
		assertTrue(f1.farolasConFocosVencidos().contains(f2));
	}
}
