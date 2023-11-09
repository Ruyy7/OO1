package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> enAlquiler;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.enAlquiler = new ArrayList<>();
	}
	
	public List<Reserva> buscarReservasDe(Usuario usuario){
		return enAlquiler.stream().flatMap(propiedad -> propiedad.buscarReservasDe(usuario).stream()).toList();
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioxNoche, String direccion) {
		Propiedad propiedad = new Propiedad (nombre,descripcion,precioxNoche,direccion);
		this.enAlquiler.add(propiedad);
		return propiedad;
	}
	
	public double ingresos (DateLapse periodo) {
		return this.enAlquiler.stream()
			.flatMapToDouble(p -> p.getReservas().stream()
			.filter(r -> r.getPeriodo().overlaps(periodo))
			.mapToDouble(r -> r.precio())).sum();
	}

	public List<Propiedad> getEnAlquiler() {
		return this.enAlquiler;
	}
	
}