package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta (String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public Carpeta (String nombre, List<Email> coleccion) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>(coleccion);
	}
	
	public int tamaño() {
		return this.nombre.length() + this.emails.stream().mapToInt(
				e -> e.tamaño()).sum();
	}
	
	public void agregarEmail(Email e) {
		this.emails.add(e);
	}
	
	public void eliminarEmail (Email e) {
		this.emails.remove(e);
	}
	
	public Email buscar(String texto) {
		return this.emails.stream().filter(e -> e.buscar(texto)).findFirst().orElse(null);
	}
	
	public List<Email> getEmails(){
		return this.emails;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
