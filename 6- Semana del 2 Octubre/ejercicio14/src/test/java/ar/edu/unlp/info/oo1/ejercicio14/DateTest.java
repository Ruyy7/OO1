package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DateTest {
	Date datelapse;
	Date lapsedate;
	
	@BeforeEach
	void setUp(){
		datelapse = new DateLapse (LocalDate.of(2002, 9, 6), LocalDate.of(2002, 9, 30));
		lapsedate = new LapseDate (LocalDate.of(2002, 9, 6), 24);
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(24,datelapse.sizeInDays());
		assertEquals(24, lapsedate.sizeInDays());
	}
	
	public void testGetTo() {
		LocalDate diaprueba = LocalDate.of(2002, 9, 30); 
		assertEquals (diaprueba,lapsedate.getTo());
	}
	
	public void testIncludesDate() {
		LocalDate diaprueba = LocalDate.of(2002, 9, 21);
		LocalDate diainicio = LocalDate.of(2002, 9, 6);
		LocalDate diafin = LocalDate.of(2002, 9, 30);
		LocalDate diafuerainicio = LocalDate.of(2002, 9, 1);
		LocalDate diafuerafin = LocalDate.of(2002, 10, 5);
		assertTrue (datelapse.includesDate(diaprueba));
		assertTrue (lapsedate.includesDate(diaprueba));
		assertTrue (datelapse.includesDate(diainicio));
		assertTrue (lapsedate.includesDate(diainicio));
		assertTrue (datelapse.includesDate(diafin));
		assertTrue (lapsedate.includesDate(diafin));
		assertFalse (datelapse.includesDate(diafuerainicio));
		assertFalse (lapsedate.includesDate(diafuerainicio));
		assertFalse (datelapse.includesDate(diafuerafin));
		assertFalse (datelapse.includesDate(diafuerafin));
	}
}
