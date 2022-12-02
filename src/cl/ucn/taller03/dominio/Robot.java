package cl.ucn.taller03.dominio;

import cl.ucn.taller03.logica.ListaPiezas;

public class Robot {

	private String nombre;
	private Estadisticas estadisticas;
	private ListaPiezas lista;

	public Robot(String nombre) {
		this.nombre = nombre;
		lista = new ListaPiezas(5);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(Estadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}

	public ListaPiezas getLista() {
		return lista;
	}

	public void setLista(ListaPiezas lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Robot [nombre=" + nombre + ", estadisticas=" + estadisticas + ", lista=" + lista.toString() + "]";
	}

}
