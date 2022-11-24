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

	
	public boolean agregarPieza(Pieza p) {
		if(cantidad < max) {
			lista[cantidad] = p;
			cantidad ++;
			return true;
		}return false;
	}
	
	public boolean verificarExiste(Pieza p) {
		for(int i = 0; i < cantidad ; i++) {
			if(lista[i].equals(p)) {
				return true;
			}
		}return false;
	}
	
	public Pieza getIndex(int i) {
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

	public Pieza[] getLista() {
		return lista;
	}

	public void setLista(Pieza[] lista) {
		this.lista = lista;
	}
	
	
	public String toString() {
		String linea = "";
		for(int i = 0; i < cantidad;i++) {
			linea+= lista[i].toString();
		}
		return linea;
	}
}
