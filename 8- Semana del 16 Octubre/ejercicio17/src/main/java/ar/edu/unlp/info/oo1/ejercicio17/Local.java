package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Local extends Llamada {
	
	public Local(LocalDate fecha, LocalTime hora, int duracion, int emisor, int remitente) {
		super(fecha, hora, duracion, emisor, remitente);
	}
	
	public double calcularPrecio() {
		return this.calcularPrecio(1);
	}
}
