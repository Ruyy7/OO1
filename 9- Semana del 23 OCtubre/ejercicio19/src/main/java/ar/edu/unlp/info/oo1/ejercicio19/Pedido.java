package ar.edu.unlp.info.oo1.ejercicio19;

public class Pedido {
	private Cliente cliente;
	private Producto producto;
	private int cantidad;
	private FormaPago modoPago;
	private Envio modoEnvio;
	
	public Pedido(Cliente cliente,Producto producto, int cantidad, FormaPago modoPago, Envio modoEnvio) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.modoPago = modoPago;
		this.modoEnvio = modoEnvio;
		this.producto.actualizarStock(cantidad);
	}
	
	public double calcularPrecio() {
		return (this.modoPago.calcularPrecioXPedido(this.producto.getPrecioXCantidad(cantidad)) + (this.modoEnvio.calcularPrecioXEnvio(this.cliente.getDireccion(), this.producto.getVendedor().getDireccion())));
	}
	
}
