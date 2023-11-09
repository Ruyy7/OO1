package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;

public class LapseDate implements Date{
	private LocalDate from;
	private int sizeInDays;

	public LapseDate(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}

	public LocalDate getFrom() {
		return this.from;
	}

	public LocalDate getTo() {
		return (this.from.plusDays(this.sizeInDays));
	}

	public int sizeInDays() {
		return this.sizeInDays;
	}

	public boolean includesDate(LocalDate other) {
		return (other.isAfter(this.from) && other.isBefore(this.getTo()));
	}

}
