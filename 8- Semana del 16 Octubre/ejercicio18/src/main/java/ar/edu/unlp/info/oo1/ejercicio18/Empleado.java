package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate nacimiento;
	private boolean conyuge;
	private boolean hijos;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int cUIL, LocalDate nacimiento, boolean conyuge, boolean hijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.CUIL = cUIL;
		this.nacimiento = nacimiento;
		this.conyuge = conyuge;
		this.hijos = hijos;
		this.contratos = new ArrayList<Contrato>();
	}
	
	public PorHoras registrarContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int numeroHoras) {
		PorHoras porHoras = new PorHoras (fechaInicio,valorHora,numeroHoras,fechaFin);
		this.contratos.add(porHoras);
		return porHoras;
	}
	
	public DePlanta registrarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
		DePlanta dePlanta = new DePlanta (this,fechaInicio,sueldoMensual,montoConyuge,montoHijos);
		this.contratos.add(dePlanta);
		return dePlanta;
	}
	
	public int calcularAntiguedad() {
		return this.contratos.stream().mapToInt(c -> c.duracion()).sum();
	}
	
	public double calcularCobro() {
		if (this.contratoReciente().noEstaVencido()) {
			if (this.calcularAntiguedad() >=5 && this.calcularAntiguedad() < 10) {
				return this.contratoReciente().montoACobrar() * 1.3;
			}
			else if (this.calcularAntiguedad() >=10 && this.calcularAntiguedad() < 15) {
				return this.contratoReciente().montoACobrar() * 1.5;
			}
			else if (this.calcularAntiguedad() >=15 && this.calcularAntiguedad() < 20) {
				return this.contratoReciente().montoACobrar() * 1.7;
			}
			else if (this.calcularAntiguedad() >= 20){
				return this.contratoReciente().montoACobrar() * 2;
			}
			else {
				return this.contratoReciente().montoACobrar();
			}
		}
		return 0;
	}
	
	public Contrato contratoReciente() {
		return this.contratos.stream().max((c1,c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null);
	}
	
	public Recibo generarRecibo() {
		if (this.contratoReciente() != null && this.contratoReciente().noEstaVencido()) {
			return new Recibo (this.nombre,this.apellido,this.CUIL,this.calcularAntiguedad(),LocalDate.now(),this.calcularCobro());
		}
		return null;
	}
	
	public boolean tieneConyuge() {
		return this.conyuge;
	}
	
	public boolean tieneHijos() {
		return this.hijos;
	}
	
	public int getCUIL() {
		return this.CUIL;
	}
}
