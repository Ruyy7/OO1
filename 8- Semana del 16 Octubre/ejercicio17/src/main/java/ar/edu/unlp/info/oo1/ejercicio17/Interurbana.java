package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Interurbana extends Llamada {
	private int km;
	
	public Interurbana(LocalDate fecha, LocalTime hora, int duracion, int emisor, int remitente, int km) {
		super(fecha, hora, duracion, emisor, remitente);
		this.km = km;
	}
	
	@Override
	public double calcularPrecio() {
		if (km < 100) {
			return super.calcularPrecio(2) + 5;
		}
		else if (km >= 100 && km <= 500) {
			return super.calcularPrecio(2.5) + 5;
		}
		else {
			return super.calcularPrecio(3) + 5;
		}
	}
}
