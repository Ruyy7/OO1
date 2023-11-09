package ar.edu.unlp.info.oo1.Ejercicio3;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> item;
	
	public Presupuesto (String cliente) {
		this.fecha=LocalDate.now();
		this.cliente = cliente;
		this.item = new ArrayList<Item>();
	}
	
	public void agregarItem (Item item) {
		this.item.add(item);
	}
	
	public double calcularTotal() {
		double total =0;
		if (this.item.size() > 0) {
			for (int i=0; i<item.size(); i++) {
				total+= item.get(i).costo();
			}
		}
		return total;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public String getCliente() {
		return this.cliente;
	}
	
	
}
