package ar.edu.unlp.info.oo1.ejercico8;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}

	public double costoEnBaseA(double precioKWh) {
		return this.consumoEnergiaActiva * precioKWh;
	}
	
	public double factorDePotencia() {
		double divisor = Math.sqrt((Math.pow(this.consumoEnergiaActiva,2)) + (Math.pow(this.consumoEnergiaReactiva, 2)));
		return this.consumoEnergiaActiva / divisor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}
	
}
