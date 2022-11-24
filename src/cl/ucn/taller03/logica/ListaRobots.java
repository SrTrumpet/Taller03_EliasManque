package cl.ucn.taller03.logica;

import cl.ucn.taller03.dominio.Robot;

public class ListaRobots {

	private int max;
	private int cantidad;
	private Robot[] lista;
	
	public ListaRobots(int max) {
		this.max = max;
		cantidad = 0;
		lista = new Robot[max];
	}
	
	public boolean agregarRobot(Robot r) {
		if(cantidad < max) {
			lista[cantidad] = r;
			cantidad++;
			return true;
		}return false;
	}
	
	
	public Robot index(int i) {
		return lista[i];
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Robot[] getLista() {
		return lista;
	}

	public void setLista(Robot[] lista) {
		this.lista = lista;
	}
	
	
}
