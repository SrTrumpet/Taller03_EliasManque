package cl.ucn.taller03.dominio;

import cl.ucn.taller03.logica.ListaRobots;

public class Piloto {

	private String piloto;
	private ListaRobots lista;
	private Equipo equipo;

	public Piloto(String piloto) {
		super();
		this.piloto = piloto;
		this.equipo = null;
		lista = new ListaRobots(10);
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public ListaRobots getLista() {
		return lista;
	}

	public void setLista(ListaRobots lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return " Piloto [piloto=" + piloto + ", equipo=" + equipo.toString() +"]";
	}

	

	
}
