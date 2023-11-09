package ar.edu.unlp.info.oo1.ejercicio4;

public class Circulo implements Figura {
	private double diametro;
	private double radio;
	
	public double getDiametro() {
		this.diametro = this.radio * 2;
		return this.diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(this.radio, 2);
	}
	
	public double getPerimetro () {
		return Math.PI * (this.radio * 2);
	}
}
