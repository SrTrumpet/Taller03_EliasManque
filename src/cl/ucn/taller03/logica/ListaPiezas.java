package cl.ucn.taller03.logica;

import cl.ucn.taller03.dominio.Pieza;

public class ListaPiezas {
	
	private int max;
	private int cantidad;
	private Pieza[] lista;
	
	public ListaPiezas(int max) {
		this.max = max;
		this.cantidad = 0;
		this.lista = new Pieza[max];
	}
	
	

}
