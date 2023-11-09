package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private List<Producto> productos;
	
	public double impuesto() {
		return getPrecioTotal() * 0.21;
	}

	public java.time.LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPesoTotal() {
		double peso = 0;
		for (Producto productos: this.productos) {
			peso += productos.getPeso();
		}
		return peso;
	}


	public double getPrecioTotal() {
		double precio = 0;
		for (Producto productos: this.productos) {
			precio += productos.getPrecio();
		}
		return precio;
	}


	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
