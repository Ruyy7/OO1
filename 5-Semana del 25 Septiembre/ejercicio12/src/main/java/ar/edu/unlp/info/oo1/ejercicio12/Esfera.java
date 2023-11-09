package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza{
	
	private int radio;
	
	public Esfera(String material, String color,Integer radio) {
		super(material, color);
		this.radio=radio;
	}

	@Override
	public double getVolumenDeMaterial(String nombredematerial) {
		return (4/3) * Math.PI * Math.pow(this.radio, 3);
	}

	@Override
	public double getSuperficieDeColor(String unNombreDeColor) {
		return 4 * Math.PI * Math.pow(this.radio, 2);
	}
	
}
