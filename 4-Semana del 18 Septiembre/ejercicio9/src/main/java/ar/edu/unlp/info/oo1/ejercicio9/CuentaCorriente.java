package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta{

	private double descubierto;
	
	public CuentaCorriente () {
		super();
		this.descubierto = 0;
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		if ((this.getSaldo() - monto) >= descubierto) {
			return true;
		}
		return false;
	}

	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	

}
