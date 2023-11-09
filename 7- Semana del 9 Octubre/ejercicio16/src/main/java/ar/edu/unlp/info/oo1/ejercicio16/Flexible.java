package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class Flexible implements Politica {

	@Override
	public double calcularMonto(Reserva reserva, LocalDate fechatentativa) {
		if (fechatentativa.isBefore(reserva.getPeriodo().getFrom())) {
			return reserva.precio();
		}
		return 0;
	}
}
