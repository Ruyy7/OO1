package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	private LocalDate fecha;
	private LocalTime hora;
	private int duracion;
	private int emisor;
	private int remitente;
	
	public Llamada(LocalDate fecha, LocalTime hora, int duracion, int emisor, int remitente) {
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.emisor = emisor;
		this.remitente = remitente;
	}
	
	protected double calcularPrecio(double precio) {
		return this.duracion * precio;
	}
	
	public abstract double calcularPrecio();
	
	protected boolean estaDentro(DateLapse periodo) {
		return periodo.includesDate(this.fecha);
	}
	
	protected LocalTime getHora() {
		return this.hora;
	}
	
}
