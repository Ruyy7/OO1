package ar.edu.unlp.info.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaDeNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero (String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero () {
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.madre != null) {
			return this.madre.getPadre();
		}
		else {
			return null;
		}
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.madre != null) {
			return this.madre.getMadre();
		}
		else {
			return null;
		}
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.madre != null) {
			return this.padre.getPadre();
		}
		else {
			return null;
		}
	}
	
	public Mamifero getAbuelaPaterna() {
		if (this.madre != null) {
			return this.padre.getMadre();
		}
		else {
			return null;
		}
	}
	
	public boolean tieneComoAncestroA (Mamifero m) {
		if (this.equals(m)) {
			return false;
		}
		else {
			return recursivo (m);
		}
	}
	
	private boolean recursivo (Mamifero ancestro) {
		boolean ok = false;
		if (this.equals(ancestro)) {
			return true;
		}
		else {
			if (!ok && this.getMadre() != null) {
				ok = this.getMadre().recursivo(ancestro);
			}
			if (!ok && this.getPadre() != null) {
				ok = this.getPadre().recursivo(ancestro);
			}
		}
		return ok;
	}
}
