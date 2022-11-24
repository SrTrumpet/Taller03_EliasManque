package cl.ucn.taller03.dominio;

import cl.ucn.taller03.logica.ListaRobots;

public class Equipo {

	
	private String nombreEquipo;
	private ListaRobots lista;
	private Piloto piloto;
	
	public Equipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
		lista = new ListaRobots(10);
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public ListaRobots getLista() {
		return lista;
	}

	public void setLista(ListaRobots lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + "Nombre piloto= "+piloto.getPiloto()+"]";
	}
	
	
	
	
	
}
