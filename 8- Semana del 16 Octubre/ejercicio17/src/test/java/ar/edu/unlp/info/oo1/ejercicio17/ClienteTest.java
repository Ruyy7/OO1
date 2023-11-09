package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	Individuo pablo;
	PersonaJuridica juana;
	Local l1,l2,l3;
	Interurbana iu1,iu2,iu3,iu4;
	Internacional in1,in2,in3;
	DateLapse d1,d2,d3,d4;
	
	@BeforeEach
	void setUp() {
		pablo = new Individuo("Pablo", "Calle A", 123, 12345678);
        juana = new PersonaJuridica("Juana", "Avenida Z", 333, 33445566, "Tipo C");
        
        d1 = new DateLapse(LocalDate.of(2023, 10, 1),LocalDate.of(2023, 10, 4));
        d2 = new DateLapse(LocalDate.of(2023, 10, 1),LocalDate.of(2023, 10, 7));
        d3 = new DateLapse(LocalDate.of(2023, 10, 17),LocalDate.of(2023, 10, 19));
        d4 = new DateLapse(LocalDate.of(2023, 10, 15),LocalDate.of(2023, 10, 19));

        l1 = pablo.realizarLlamadaLocal(LocalDate.of(2023, 10, 1), LocalTime.of(12, 30), 10, 123);
        l2 = pablo.realizarLlamadaLocal(LocalDate.of(2023, 10, 2), LocalTime.of(13, 45), 15, 456);
        iu1 = pablo.realizarLlamadaInterurbana(LocalDate.of(2023, 10, 3), LocalTime.of(13, 0), 20, 789, 501);
        iu2 = pablo.realizarLlamadaInterurbana(LocalDate.of(2023, 10, 3), LocalTime.of(14, 0), 20, 789, 99);
        in1 = pablo.realizarLlamadaInternacional(LocalDate.of(2023, 10, 4), LocalTime.of(8, 0), 25, 789, "PaisO1", "PaisD1");
        in2 = pablo.realizarLlamadaInternacional(LocalDate.of(2023, 10, 7), LocalTime.of(20, 0), 40, 456, "PaisO2", "PaisD2");

        l3 = juana.realizarLlamadaLocal(LocalDate.of(2023, 10, 17), LocalTime.of(21, 0), 90, 777);
        iu3 = juana.realizarLlamadaInterurbana(LocalDate.of(2023, 10, 18), LocalTime.of(21, 30), 15, 888, 100);
        iu4 = juana.realizarLlamadaInterurbana(LocalDate.of(2023, 10, 15), LocalTime.of(20, 0), 20, 555, 500);
        in3 = juana.realizarLlamadaInternacional(LocalDate.of(2023, 10, 19), LocalTime.of(20, 1), 6, 999, "PaisO6", "PaisD6");
	}
	
	@Test
	public void facturarLlamadaIndividuoTest() {
		Factura f1,f2;
		f1 = pablo.facturarLlamada(d1);
		f2 = pablo.facturarLlamada(d2);
		assertEquals (211.5,f1.getMontoTotal());
		assertEquals (355.5,f2.getMontoTotal());
	}
	
	@Test
	public void facturarLlamadaPjTest() {
		Factura f3,f4;
		f3 = juana.facturarLlamada(d3);
		f4 = juana.facturarLlamada(d4);
		assertEquals (150.5,f3.getMontoTotal());
		assertEquals (205.5,f4.getMontoTotal());
	}
}
