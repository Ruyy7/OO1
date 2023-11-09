package ar.edu.unlp.info.oo1.ejercicio2;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
public class Balanza {
	private List<Producto> productos = new ArrayList<Producto>(); 
	
	public void ponerEnCero() {;
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto (Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket();
		t.setProductos(new ArrayList<Producto>(this.productos)); t.setFecha(LocalDate.now());
		return t;
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}


	public double getPrecioTotal() {
		double precio = 0;
		if (productos.size()>0) {
			for (Producto productos: this.productos) {
				precio += productos.getPrecio();
			}
		}
		return precio;
	}


	public double getPesoTotal() {
		double peso = 0;
		if (productos.size()>0) {
			for (Producto productos: this.productos) {
				peso += productos.getPeso();
			}
		}
		return peso;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	
	
}
