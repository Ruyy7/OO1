package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoolCar {
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Viaje> viajes = new ArrayList<>();
	
	public Conductor registrarConductor (String nombre, Vehiculo vehiculo) {
		Conductor conductor = new Conductor (nombre,vehiculo);
		this.usuarios.add(conductor);
		return conductor;
	}
	
	public Pasajero registrarPasajero (String nombre) {
		Pasajero pasajero = new Pasajero (nombre);
		this.usuarios.add(pasajero);
		return pasajero;
	}
	
	public Viaje registrarViaje (Conductor conductor, String origen, String destino, double costoTotal, LocalDate fecha) {
		Viaje viaje = new Viaje(conductor,origen,destino,costoTotal,fecha);
		this.viajes.add(viaje);
		return viaje;
	}
	
	public List<Usuario> usuariosRegistrados(){
		return this.usuarios.stream().sorted((u1, u2) -> Double.compare(u2.getSaldo(), u1.getSaldo())).collect(Collectors.toList());
	}
	
	public List<Viaje> listarViajesMañana(){
		return this.viajes.stream().filter(v -> v.getFecha().until(LocalDate.of(2023, 11, 4)).getDays() == 1).collect(Collectors.toList());
	}
	
	public void procesarViajesMañana() {
		this.listarViajesMañana().forEach(v -> v.procesarPasajeros());
	}
}
