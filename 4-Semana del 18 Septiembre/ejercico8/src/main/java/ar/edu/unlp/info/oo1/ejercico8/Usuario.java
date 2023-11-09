package ar.edu.unlp.info.oo1.ejercico8;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario (String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public Consumo ultimoConsumo() {
		return this.consumos.stream().max((c1, c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}
	
	public Factura facturarEnBaseA (double precioKWh) {
		double descuento = 0;
		Factura factura;
		if (this.ultimoConsumo() == null) {
			factura = new Factura(0,0,this);
		}
		else {
			if (this.ultimoConsumo().factorDePotencia() > 0.8) {
				descuento = 10;
			}
			factura = new Factura (this.ultimoConsumo().costoEnBaseA(precioKWh),descuento,this);
		}
		return factura;
	}
	
	public double ultimoConsumoActiva() {
		return this.ultimoConsumo().getConsumoEnergiaActiva();
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}
}
