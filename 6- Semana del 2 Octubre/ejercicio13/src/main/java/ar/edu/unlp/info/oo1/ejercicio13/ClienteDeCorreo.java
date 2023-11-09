package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo (Carpeta inbox) {
		this.inbox = inbox;
		this.carpetas = new ArrayList<>();
	}
	
	public ClienteDeCorreo (Carpeta inbox, List<Carpeta> coleccion) {
		this.inbox = inbox;
		this.carpetas = new ArrayList<>(coleccion);
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void mover (Email email, Carpeta origen, Carpeta destino) {
		origen.eliminarEmail(email);
		destino.agregarEmail(email);
	}
	
	public Email buscar (String texto) {
		return this.carpetas.stream().map(c -> c.buscar(texto)).filter(e -> e != null).findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(c -> c.tamaño()).sum();
	}
	
	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}
	
	public List<Carpeta> getCarpetas(){
		return this.carpetas;
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
}
