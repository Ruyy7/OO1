package ar.edu.unlp.info.oo1.ejercicio19;

public class ExpresDomicilio implements Envio {
	private Mapa mapa;

	public ExpresDomicilio (Mapa mapa) {
		this.mapa = mapa;
	}
	public double calcularPrecioXEnvio(String dir1, String dir2) {
		return mapa.distanciaEntre(dir1, dir2);
	}

}
