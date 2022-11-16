package cl.ucn.taller03.dominio;

import cl.ucn.taller03.logica.ListaPiezas;

public class Robot {

	private String nombre;
	private int estadisticas;
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

	public int getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(int estadisticas) {
		this.estadisticas = estadisticas;
	}

	public ListaPiezas getLista() {
		return lista;
	}

	public void setLista(ListaPiezas lista) {
		this.lista = lista;
	}
	
	
	
	
	
	
	
}
