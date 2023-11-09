package ar.edu.unlp.info.oo1.ejercico8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> users = new ArrayList<>();
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
	}

	public Distribuidora() {
	}

	public void agregarUsuario (Usuario usuario) {
		this.users.add(usuario);
	}

	public List<Usuario> getUsuarios() {
		return users;
	}

	public Double getPrecioKW() {
		return this.precioKWh;
	}
	
	public void precioKWh (double precio) {
		this.precioKWh = precio;
	}

	public List<Factura> facturar() {
		return this.users.stream().map(u -> u.facturarEnBaseA(this.precioKWh)).collect(Collectors.toList());
	}
	
	public double consumoTotalActiva() {
		return this.users.stream().mapToDouble(u -> u.ultimoConsumoActiva()).sum();
	}
}
