package ar.edu.unlp.info.oo1.ejercicio21;

public abstract class Usuario {
	private String nombre;
	private double saldo;
	
	public Usuario (String nombre) {
		this.nombre = nombre;
	}
	
	public void procesarViaje(double costoviaje) {
		this.saldo = (this.saldo - costoviaje) + this.cargarMontoRegalo();
	}
	
	public void cargarSaldo(double monto) {
		this.saldo+=this.calcularComision(monto);
	}
	
	protected abstract double cargarMontoRegalo();
	
	protected abstract double calcularComision(double monto);

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
