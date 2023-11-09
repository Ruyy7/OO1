package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioxNoche;
	private String direccion;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, double precio, String direccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioxNoche = precio;
		this.direccion = direccion;
		this.reservas = new ArrayList<>();
	}
	
	public List<Reserva> buscarReservasDe(Usuario usuario){
		return reservas.stream().filter(r -> r.getInquilino() == usuario).toList();
	}
	
	public boolean estaDisponibleEn(DateLapse periodo) {
		return this.reservas.stream().noneMatch(r -> r.estaOcupadaEn(periodo));
	}
	
	public Reserva realizarReserva(DateLapse periodo, Usuario inquilino) {
		if (this.estaDisponibleEn(periodo)) {
			Reserva reserva = new Reserva (this, periodo, inquilino);
			this.reservas.add(reserva);
			return reserva;	
		}
		return null;
	}
	
	public void eliminarReserva(Reserva reserva) {
		if (reserva.esEliminable()) {
			this.reservas.remove(reserva);		
		}
	}
	
	public double getPrecioxNoche() {
		return this.precioxNoche;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}
}
