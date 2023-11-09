package ar.edu.unlp.info.oo1.ejercicio17;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Integer> numeros = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	
	public void registrarNumero (int numero) {
		this.numeros.add(numero);
	}
	
	public int asignarNumero() {
		if (this.numeros.size() > 0) {
			int numero = this.numeros.get(this.numeros.size() -1);
			this.numeros.remove(this.numeros.size() -1);
			return numero;
		}
		return 0;
	}
	
	public Individuo registrarIndividuo(String nombre, String direccion, int DNI) {
		int conejito2 = this.asignarNumero();
		if (conejito2 != 0) {
			Individuo conejito = new Individuo (nombre,direccion,DNI,conejito2);
			this.clientes.add(conejito);			
			return conejito;
		}
		return null;
	}
	
	public PersonaJuridica registrarPJ(String nombre, String direccion, int CUIT, String tipo) {
		int conejito2 = this.asignarNumero();
		if (conejito2 != 0) {
			PersonaJuridica conejito = new PersonaJuridica (nombre,direccion,conejito2,CUIT,tipo);
			this.clientes.add(conejito);			
			return conejito;
		}
		return null;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
}
