package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class Estricta implements Politica {

	@Override
	public double calcularMonto(Reserva reserva, LocalDate fechatentativa) {
		return 0;
	}

}
