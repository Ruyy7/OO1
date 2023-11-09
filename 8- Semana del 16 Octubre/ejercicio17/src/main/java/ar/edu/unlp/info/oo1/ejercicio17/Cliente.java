package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private int numero;
	private List<Llamada> llamadas;
	
	public Cliente(String nombre, String direccion, int numero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.llamadas = new ArrayList<>();
	}
	
	public abstract Factura facturarLlamada(DateLapse periodo);
	
	public Local realizarLlamadaLocal(LocalDate fecha, LocalTime hora, int minutos, int receptor) {
		Local llamada = new Local (fecha,hora,minutos,this.numero,receptor);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Interurbana realizarLlamadaInterurbana(LocalDate fecha, LocalTime hora, int minutos, int receptor, int km) {
		Interurbana llamada = new Interurbana (fecha,hora,minutos,this.numero,receptor,km);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Internacional realizarLlamadaInternacional(LocalDate fecha, LocalTime hora, int minutos, int receptor, String paisO, String paisD) {
		Internacional llamada = new Internacional (fecha, hora,minutos,this.numero,receptor,paisO,paisD);
		this.llamadas.add(llamada);
		return llamada;
	}

	public List<Llamada> getLlamadas() {
		return this.llamadas;
	}
	
	public int getNumero() {
		return this.numero;
	}
}
