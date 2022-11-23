package cl.ucn.taller03.dominio;

public class Equipo {

	
	private String nombreEquipo;
	private Robot robot;
	private Piloto piloto;
	
	public Equipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
		robot = null;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	
	
	
}
