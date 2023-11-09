package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.List;
import java.util.ArrayList;

public class Farola {
	private boolean on;
	private List<Farola> vecinas;
	
	public Farola () {
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
		if (this.on == false) {
			this.on = true;
			for (Farola farola: this.vecinas) {
				farola.turnOn();
			}
		}
	}
	public void turnOff() {
		if (this.on == true) {
			this.on = false;
			for (Farola farola: this.vecinas) {
				farola.turnOff();
			}
		}
	}
	
	public boolean isOn() {
		return this.on;
	}
}
