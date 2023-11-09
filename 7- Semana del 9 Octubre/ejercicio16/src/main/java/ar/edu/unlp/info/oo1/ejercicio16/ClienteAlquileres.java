package ar.edu.unlp.info.oo1.ejercicio16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ClienteAlquileres {
	private List<Usuario> usuarios= new ArrayList<>();
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre,direccion,dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public List<Reserva> reservasUsuario (Usuario inquilino){
		return this.usuarios.stream().flatMap(u -> u.buscarReservasDe(inquilino).stream()).toList();
	}
	
	public List<Propiedad> buscarPropiedadesDisbonibleEn (DateLapse periodo){
		return this.usuarios.stream()
				.flatMap(propietario -> propietario.getEnAlquiler().stream())
				.filter(propiedad -> propiedad.estaDisponibleEn(periodo))
				.collect(Collectors.toList());
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
