package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public double volumenDeMaterial(String material) {
		double total= this.piezas.stream().filter(pieza -> pieza.getMaterial() == material)
				.mapToDouble(pieza -> pieza.getVolumenDeMaterial(material)).sum();
		return total;
	}
	
	public double superficieDeColor(String color) {
		double total = this.piezas.stream().filter(pieza -> pieza.getColor() == color)
				.mapToDouble(pieza -> pieza.getSuperficieDeColor(color)).sum();
		return total;
	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	//Preguntar si esta bien hecho o es mejor que la pieza verifique su material
}
