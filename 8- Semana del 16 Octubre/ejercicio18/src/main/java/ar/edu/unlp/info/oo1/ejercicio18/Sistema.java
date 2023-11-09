package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Empleado> empleados = new ArrayList<>();
	
	public Empleado registrarEmpleado (String nombre, String apellido, int CUIL, LocalDate nacimiento, boolean conyuge, boolean hijos) {
		Empleado empleado = new Empleado (nombre,apellido,CUIL,nacimiento,conyuge,hijos);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Empleado buscarEmpleado (int CUIL) {
		return this.empleados.stream().filter(e -> e.getCUIL() == CUIL).findAny().orElse(null);
	}
	
	public List<Empleado> empleadosVencidos(){
		return this.empleados.stream().filter(e -> !e.contratoReciente().noEstaVencido()).collect(Collectors.toList());
	}
	
	public List<Recibo> generarRecibos(){
		return this.empleados.stream().filter(e -> !this.empleadosVencidos().contains(e)).map(e -> e.generarRecibo()).collect(Collectors.toList());
	}
	
	public void bajaEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
}
