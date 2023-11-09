package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class PorHoras extends Contrato {
	private double valorHora;
	private int numeroHoras;
	private LocalDate fechaFin;
	
	public PorHoras(LocalDate fechaInicio, double valorHora, int numeroHoras, LocalDate fechaFin) {
		super(fechaInicio);
		this.valorHora = valorHora;
		this.numeroHoras = numeroHoras;
		this.fechaFin = fechaFin;
	}

	@Override
	public double montoACobrar() {
		return this.valorHora * this.numeroHoras;
	}

	@Override
	public int duracion() {
		return this.getFechaInicio().until(this.fechaFin).getYears();
	}

	@Override
	public boolean noEstaVencido() {
		return this.fechaFin.isAfter(LocalDate.now());
	}

}
