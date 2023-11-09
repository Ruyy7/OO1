package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private int CUIL;
	private int antiguedad;
	private LocalDate fechaRecibo;
	private double montoTotal;
	
	public Recibo(String nombre, String apellido, int CUIL, int antiguedad, LocalDate fechaRecibo, double montoTotal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = CUIL;
		this.antiguedad = antiguedad;
		this.fechaRecibo = fechaRecibo;
		this.montoTotal = montoTotal;
	}

	public double getMontoTotal() {
		return montoTotal;
	}
	
	
}
