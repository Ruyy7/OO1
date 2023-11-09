package ar.edu.unlp.info.oo1.ejercicio21;

public class Conductor extends Usuario {
	private Vehiculo vehiculo;
	
	public Conductor (String nombre, Vehiculo vehiculo) {
		super (nombre);
		this.vehiculo = vehiculo;
	}
	
	@Override
	protected double calcularComision(double monto) {
		if (this.vehiculo.getAntiguedad() < 5) {
			return monto * 0.99;			
		}
		else {
			return monto * 0.9;
		}
	}

	@Override
	protected double cargarMontoRegalo() {
		return this.vehiculo.getValor() * 0.001;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

}
