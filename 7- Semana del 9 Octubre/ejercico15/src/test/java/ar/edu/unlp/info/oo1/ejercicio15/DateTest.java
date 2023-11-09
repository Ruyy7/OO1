package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DateTest {
	DateLapse datelapse,datelapse2,datelapse3,datelapse4, datelapse5;
	
	@BeforeEach
	void setUp(){
		datelapse = new DateLapse (LocalDate.of(2002, 9, 6), LocalDate.of(2002, 9, 21));
		datelapse2 = new DateLapse (LocalDate.of(2002, 9, 22), LocalDate.of(2002, 9, 30));
		datelapse3 = new DateLapse (LocalDate.of(2002, 9, 21), LocalDate.of(2002, 9, 30));
		datelapse4 = new DateLapse (LocalDate.of(2002, 9, 1), LocalDate.of(2002, 9, 6));
		datelapse5 = new DateLapse (LocalDate.of(2002, 9, 2), LocalDate.of(2002, 9, 5));
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(15,datelapse.sizeInDays());
	}
	
	@Test
	public void overlapsTest() {
		assertFalse (datelapse.overlaps(datelapse2));
		assertTrue (datelapse.overlaps(datelapse3));
		assertTrue (datelapse.overlaps(datelapse4));
		assertTrue(datelapse4.overlaps(datelapse5));
	}
}
