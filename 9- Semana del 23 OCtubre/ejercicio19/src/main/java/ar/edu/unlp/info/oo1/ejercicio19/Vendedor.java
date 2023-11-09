package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
	private List<Producto> productos;
	
	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new ArrayList<>();
	}
	
	public Producto registrarProducto(String nombre, String descripcion, double precio, int stock) {
		Producto producto = new Producto(this,nombre,descripcion,precio,stock);
		this.productos.add(producto);
		return producto;
	}
}
