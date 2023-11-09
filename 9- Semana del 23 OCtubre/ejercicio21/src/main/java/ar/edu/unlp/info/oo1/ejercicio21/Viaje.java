package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
	private String origen;
	private String destino;
	private double costoTotal;
	private LocalDate fecha;
	private Vehiculo vehiculo;
	private List<Usuario> pasajeros;
	
	public Viaje(Conductor conductor, String origen, String destino, double costoTotal, LocalDate fecha) {
		this.origen = origen;
		this.destino = destino;
		this.costoTotal = costoTotal;
		this.fecha = fecha;
		this.vehiculo = conductor.getVehiculo();
		this.pasajeros = new ArrayList<>();
		this.pasajeros.add(conductor);
	}
	
	public void registrarPasajero (Pasajero pasajero) {
			if (pasajero.tieneSaldoSuficiente(this.getCostoTotal()) && this.puedeReservar()) {
				pasajero.registrarViaje(this);
				this.pasajeros.add(pasajero);
			}
	}
	
	public boolean puedeReservar() {
		int aux = this.fecha.until(LocalDate.of(2023,11,4)).getDays();
		return (this.vehiculo.getCapacidad() - this.pasajeros.size() > 0) && (this.fecha.until(LocalDate.of(2023, 11, 4)).getDays() > 2);
	}
	
	public void procesarPasajeros(){
		this.pasajeros.forEach(p -> p.procesarViaje(this.costoTotal));;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public List<Usuario> getPasajeros() {
		return this.pasajeros;
	}

	public double getCostoTotal() {
		return this.costoTotal;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
}
