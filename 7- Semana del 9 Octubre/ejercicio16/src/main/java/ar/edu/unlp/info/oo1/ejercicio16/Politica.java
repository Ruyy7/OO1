package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public interface Politica {
	double calcularMonto(Reserva reserva, LocalDate fechatentativa);
}
