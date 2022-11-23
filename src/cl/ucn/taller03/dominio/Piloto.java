package cl.ucn.taller03.dominio;

public class Piloto {

	private String piloto;
	private Robot robot;
	private Equipo equipo;
	
	public Piloto(String piloto) {
		super();
		this.piloto = piloto;
		this.equipo = null;
		this.robot = null;
	}
	
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
}
