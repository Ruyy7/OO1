package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> personas;
	
	public Sistema() {
		this.personas = new ArrayList<>();
	}
	
	public Cliente registrarCliente(String nombre, String direccion) {
		Cliente cliente = new Cliente(nombre,direccion);
		this.personas.add(cliente);
		return cliente;
	}
	
	public Vendedor registrarVendedor(String nombre, String direccion) {
		Vendedor vendedor = new Vendedor(nombre,direccion);
		this.personas.add(vendedor);
		return vendedor;
	}
	
	public Persona buscarPersona(String nombre) {
		return this.personas.stream().filter(p -> p.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
}
