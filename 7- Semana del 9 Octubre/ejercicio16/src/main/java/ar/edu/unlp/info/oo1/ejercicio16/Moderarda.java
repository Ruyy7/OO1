package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class Moderarda implements Politica {

	@Override
	public double calcularMonto(Reserva reserva, LocalDate fechatentativa) {
		if (fechatentativa.isBefore(reserva.getPeriodo().getFrom())) {
			return reserva.precio();
		}
		else if (fechatentativa.until(reserva.getPeriodo().getFrom()).getDays() <= 2) {
			return reserva.precio() / 2;
		}
		return 0;
	}

}
