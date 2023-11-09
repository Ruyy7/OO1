package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{
	private List<Viaje> viajes;

	public Pasajero(String nombre) {
		super(nombre);
		this.viajes = new ArrayList<>();
	}
	
	private Viaje viajeMasReciente() {
		return this.viajes.stream().max((v1,v2) -> v1.getFecha().compareTo(v2.getFecha())).orElse(null);
	}

	@Override
	protected double cargarMontoRegalo() {
		if (!this.viajes.isEmpty()) {
			return 500;
		}
		else {
			return 0;
		}
	}
	
	@Override
	protected double calcularComision(double monto) {
		if (this.viajeMasReciente() != null && (int) ChronoUnit.DAYS.between(this.viajeMasReciente().getFecha(),LocalDate.of(2023,11,4)) <= 30) {
			return monto;
		}
		else {
			return monto * 0.9;
		}
	}
	
	public boolean tieneSaldoSuficiente(double monto) {
		return (this.getSaldo() - monto >= 0);
	}
	
	public void registrarViaje(Viaje viaje){
		this.viajes.add(viaje);
	}
	public List<Viaje> getViajes() {
		return this.viajes;
	}
	
}
