package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new ArrayList<>();
	}
	
	public Pedido registrarPedido(Producto producto, int cantidad, FormaPago modoPago, Envio modoEnvio) {
		Pedido pedido = new Pedido(this,producto,cantidad,modoPago,modoEnvio);
		this.pedidos.add(pedido);
		return pedido;
	}
	
}
