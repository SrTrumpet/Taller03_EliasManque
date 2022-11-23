package cl.ucn.taller03.dominio;

public class RobotAlien extends Robot {

	private String clase;
	private int vida;
	private int dañoAdicional;

	public RobotAlien(String nombre, String clase, int vida, int dañoAdicional) {
		super(nombre);
		this.clase = clase;
		this.vida = vida;
		this.dañoAdicional = dañoAdicional;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDañoAdicional() {
		return dañoAdicional;
	}

	public void setDañoAdicional(int dañoAdicional) {
		this.dañoAdicional = dañoAdicional;
	}

	@Override
	public String toString() {
		return "RobotAlien [clase=" + clase + ", vida=" + vida + ", dañoAdicional=" + dañoAdicional + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
}
