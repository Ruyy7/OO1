package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private Propiedad propiedad;
	private DateLapse periodo;
	private Usuario inquilino;
	
	public Reserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		this.propiedad = propiedad;
		this.periodo = periodo;
		this.inquilino = inquilino;
	}

	public double precio() {
		return this.propiedad.getPrecioxNoche() * this.periodo.sizeInDays();
	}
	
	public boolean esEliminable() {
		return (LocalDate.now().isAfter(this.periodo.getTo()));
	}
	
	public boolean estaOcupadaEn (DateLapse periodo) {
		return this.periodo.overlaps(periodo);
	}

	public DateLapse getPeriodo() {
		return this.periodo;
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public Usuario getInquilino() {
		return this.inquilino;
	}
}
