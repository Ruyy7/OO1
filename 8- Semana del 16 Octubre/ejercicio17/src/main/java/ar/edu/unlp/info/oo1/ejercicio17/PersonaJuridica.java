package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class PersonaJuridica extends Cliente {
	private int CUIT;
	private String tipo;
	
	public PersonaJuridica(String nombre, String direccion, int numero, int CUIT, String tipo) {
		super(nombre, direccion, numero);
		this.CUIT = CUIT;
		this.tipo = tipo;
	}
	
	@Override
	public Factura facturarLlamada(DateLapse periodo) {
		return new Factura (this,LocalDate.now(),periodo,this.getLlamadas().stream().filter(l -> l.estaDentro(periodo)).mapToDouble(l -> l.calcularPrecio()).sum());
	}
	
}
