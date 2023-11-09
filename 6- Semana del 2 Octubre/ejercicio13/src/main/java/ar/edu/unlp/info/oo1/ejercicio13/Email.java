package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email (String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public int tamaño() {
		return this.titulo.length() + this.cuerpo.length() + this.adjuntos.stream().mapToInt(
				a -> a.tamaño()).sum();
	}
	
	public boolean buscar(String texto) {
		return (this.titulo.equals(texto) || this.cuerpo.equals(texto));
	}
	
	public void agregarArchivo(Archivo a) {
		this.adjuntos.add(a);
	}
	
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
}
