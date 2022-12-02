package cl.ucn.taller03.dominio;

public class Estadisticas {

	private int ataque;
	private int vida;
	private int velocidad;
	private int velocidadAtaque;
	private int daño;
	private Robot robot;

	public Estadisticas(Robot r) {
		this.robot = r;
	}

	public void añadirVida(int vida) {
		this.vida += vida;
	}
	
	public void añadirAtaque(int ataque) {
		this.ataque += ataque;
	}

	public void añadirVidaRobot(int vida) {
		this.vida += vida;
	}

	public void añadirVelocidad(int velocidad) {
		this.velocidad += velocidad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelocidadAtaque() {
		return velocidadAtaque;
	}

	public void setVelocidadAtaque(int velocidadAtaque) {
		this.velocidadAtaque = velocidadAtaque;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

}
