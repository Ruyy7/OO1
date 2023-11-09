package ar.edu.unlp.info.oo1.ejercico8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
		
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
	}
	
	public double montoTotal() {
		double descuento = this.montoEnergiaActiva * (this.descuento/100);
		return this.montoEnergiaActiva - descuento;
	}

	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	
}
