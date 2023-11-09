package ar.edu.unlp.info.oo1.ejercicio19;

public class Producto {
	private Vendedor vendedor;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	
	public Producto(Vendedor vendedor,String nombre, String descripcion, double precio, int stock) {
		this.vendedor = vendedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public boolean actualizarStock(int cantidad) {
		if ((this.stock - cantidad) >= 0) {
			this.stock-=cantidad;
			return true;
		}
		return false;
	}

	public double getPrecioXCantidad(int cantidad) {
		return this.precio * cantidad;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}
	
}
