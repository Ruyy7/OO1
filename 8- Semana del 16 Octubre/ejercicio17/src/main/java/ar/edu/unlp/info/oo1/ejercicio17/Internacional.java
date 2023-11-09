package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Internacional extends Llamada {
	private String paisO;
	private String paisD;
	
	public Internacional(LocalDate fecha, LocalTime hora, int duracion, int emisor, int remitente, String paisO,String paisD) {
		super(fecha, hora, duracion, emisor, remitente);
		this.paisO = paisO;
		this.paisD = paisD;
	}

	@Override
	public double calcularPrecio() {
		if (this.getHora().getHour() >= 8 && (this.getHora().getHour() <= 20 && this.getHora().getMinute() == 0)) {
			return this.calcularPrecio(4);
		}
		else {
			return this.calcularPrecio(3);
		}
	}
	
}
