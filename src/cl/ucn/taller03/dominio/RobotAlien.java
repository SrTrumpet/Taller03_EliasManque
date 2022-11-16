package cl.ucn.taller03.dominio;

public class RobotAlien extends Robot {

	private String clase;

	public RobotAlien(String nombre, String clase) {
		super(nombre);
		this.clase = clase;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	
}
