package ar.edu.unlp.info.oo1.ejercicio16;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return this.from.until(this.to).getDays();
	}
	
	public boolean includesDate (LocalDate other) {
		return ((other.isAfter(this.from) && other.isBefore(this.to)) || ((other.isEqual(this.from) || other.isEqual(this.to))));
	}
	
	public boolean overlaps (DateLapse anotherDateLapse) {
		return ((this.includesDate(anotherDateLapse.getFrom()) || this.includesDate(anotherDateLapse.getTo())));
	}
}
