package ar.edu.unlp.info.oo1.ejercicio20;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Farola {
	private String fabricante;
	private int cantCiclos;
	private boolean on;
	private boolean estado;
	private List<Farola> vecinas;
	
	public Farola (String fabricante, int cantCiclos) {
		this.on = false;
		this.vecinas = new ArrayList<Farola>();
	}
	
	public void pairWithNeighbor (Farola otraFarola) {
		this.vecinas.add(otraFarola);
		otraFarola.vecinas.add(this);
	}
	
	public List<Farola> getNeighbors (){
		return this.vecinas;
	}
	
	public void turnOn() {
		if (this.isOn() && this.cantCiclos > 0) {
			this.on = true;
			this.cantCiclos--;
			for (Farola farola: this.vecinas) {
				farola.turnOn();
			}
		}
	}
	
	public void turnOff() {
		if (this.on) {
			this.on = false;
			for (Farola farola: this.vecinas) {
				farola.turnOff();
			}
		}
	}
	
	public boolean estaVencida() {
		return this.cantCiclos == 0;
	}
	
	private boolean isOn() {
		return this.on;
	}
	
	public List<Farola> farolasConFocosVencidos(){
		return this.vecinas.stream().filter(f -> f.estaVencida()).collect(Collectors.toList());
	}
}
