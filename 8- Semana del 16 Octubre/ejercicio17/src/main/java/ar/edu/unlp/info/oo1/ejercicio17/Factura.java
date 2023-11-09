package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Factura {
	private Cliente cliente;
	private DateLapse periodo;
	private double montoTotal;
	private LocalDate fechaFacturacion;
	
	public Factura(Cliente cliente, LocalDate fechaFacturacion, DateLapse periodo, double montoTotal) {
		this.cliente = cliente;
		this.periodo = periodo;
		this.montoTotal = montoTotal;
		this.fechaFacturacion = fechaFacturacion;
	}
	
	public double getMontoTotal() {
		return this.montoTotal;
	}
}
