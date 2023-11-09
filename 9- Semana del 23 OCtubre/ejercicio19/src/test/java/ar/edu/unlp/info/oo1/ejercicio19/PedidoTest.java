package ar.edu.unlp.info.oo1.ejercicio19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	Cliente c1,c2,c3,c4;
	Vendedor vendedor;
	Producto producto;
	Pedido p1,p2,p3,p4;
	FormaPago AC,SeisC;
	Envio RC,RS,ED;
	Mapa mapa;
	
	@BeforeEach
	void setUp(){
		c1 = new Cliente("Matias","Avenida 1 1900");
		c2 = new Cliente("Carla","Avenida 19 1900");
		c3 = new Cliente("Sofi","Avenida 7 1900");
		c4 = new Cliente("Marcos","Avenida 32 1900");
		vendedor = new Vendedor ("Vendedor", "Cañitas 340");
		producto = new Producto (vendedor,"Rtx 3090","Tarjeta gráfica",800,10);
		mapa = new Mapa();
		AC = new AlContado(); SeisC = new SeisCuotas();
		RC = new RetiroComercio(); RS = new RetiroSucursal(); ED = new ExpresDomicilio(mapa);
		p1 = c1.registrarPedido(producto, 3, AC, RC);
		p2 = c2.registrarPedido(producto, 3, SeisC, RS);
		p3 = c3.registrarPedido(producto, 2, AC, ED);
		p4 = c4.registrarPedido(producto, 2, SeisC, RS);
	}
	
	@Test
	public void calcularPedidoTest() {
		assertEquals(2400, p1.calcularPrecio());
		assertEquals(2930, p2.calcularPrecio());
		assertEquals(1700, p3.calcularPrecio());
		assertEquals(1970, p4.calcularPrecio());
	}
}
