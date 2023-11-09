package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		this.cantidadDeProductos=0;
		this.pesoTotal=0;
		this.precioTotal=0;
	}
	
	public void agregarProducto (Producto producto) {
		this.pesoTotal += producto.getPeso();
		this.precioTotal += producto.getPrecio();
		this.cantidadDeProductos++;
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket();
		t.setCantidadDeProductos(this.cantidadDeProductos);
		t.setPrecioTotal(this.precioTotal);
		t.setPesoTotal(this.pesoTotal);
		t.setFecha(LocalDate.now());
		return t;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public double getPesoTotal() {
		return pesoTotal;
	}

	
	
}
