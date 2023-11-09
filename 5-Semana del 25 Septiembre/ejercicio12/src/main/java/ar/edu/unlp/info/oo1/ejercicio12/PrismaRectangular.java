package ar.edu.unlp.info.oo1.ejercicio12;

public class PrismaRectangular extends Pieza{
	
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor=ladoMayor;
		this.ladoMenor=ladoMenor;
		this.altura=altura;
	}

	@Override
	public double getVolumenDeMaterial(String nombredematerial) {
		return this.ladoMayor * this.ladoMenor * this.altura;
	}

	@Override
	public double getSuperficieDeColor(String unNombreDeColor) {
		return 2 * ((this.ladoMayor * this.ladoMenor) + (this.ladoMayor * this.altura) + (this.ladoMenor * this.altura));
	}
	
}
