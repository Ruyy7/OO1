package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza{
	
	private int radio;
	private int altura;
	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio=radio;
		this.altura=altura;
	}

	@Override
	public double getVolumenDeMaterial(String nombredematerial) {
		return Math.PI * Math.pow(this.radio, 2) * this.altura;
	}

	@Override
	public double getSuperficieDeColor(String unNombreDeColor) {
		return 2 * Math.PI * this.radio * (this.altura + 2) * Math.PI * Math.pow(this.radio, 2);
	}
	
	
}
