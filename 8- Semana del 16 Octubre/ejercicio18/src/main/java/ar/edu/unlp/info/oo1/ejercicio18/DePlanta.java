package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class DePlanta extends Contrato {
	private double sueldoMensual;
	private double montoConyuge;
	private double montoHijos;
	private Empleado empleado;
		
	public DePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoConyuge,double montoHijos) {
		super(fechaInicio);
		this.empleado = empleado;
		this.sueldoMensual = sueldoMensual;
		this.montoConyuge = montoConyuge;
		this.montoHijos = montoHijos;
	}

	@Override
	public double montoACobrar() {
		double aCobrar = this.sueldoMensual;
		if (this.getEmpleado().tieneConyuge()) {
			aCobrar+=this.montoConyuge;
		}
		if (this.getEmpleado().tieneHijos()) {
			aCobrar+=this.montoHijos;
		}
		return aCobrar;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}

	@Override
	public int duracion() {
		return this.getFechaInicio().until(LocalDate.now()).getYears();
	}

	@Override
	public boolean noEstaVencido() {
		return true;
	}
	
}
