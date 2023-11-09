package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Individuo extends Cliente{
	private int DNI;

	public Individuo(String nombre, String direccion, int numero, int dni) {
		super(nombre, direccion, numero);
		this.DNI = dni;
	}
	
	@Override
	public Factura facturarLlamada(DateLapse periodo) {
		return new Factura (this,LocalDate.now(),periodo,(this.getLlamadas().stream().filter(l -> l.estaDentro(periodo)).mapToDouble(l -> l.calcularPrecio()).sum())* 0.9);
	}
	
}
