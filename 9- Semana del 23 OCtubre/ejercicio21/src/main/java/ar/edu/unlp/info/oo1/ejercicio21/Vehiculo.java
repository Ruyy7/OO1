package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.Year;

public class Vehiculo {
	private String descripcion;
	private int capacidad;
	private Year año;
	private double valor;
	
	public Vehiculo(String descripcion, int capacidad, Year año, double valor) {
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.año = año;
		this.valor = valor;
	}

	public Year getAño() {
		return this.año;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public int getAntiguedad() {
		return Year.now().minusYears(this.año.getValue()).getValue();
	}

}
