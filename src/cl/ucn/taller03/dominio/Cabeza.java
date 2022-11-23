package cl.ucn.taller03.dominio;

public class Cabeza extends Pieza{
	
	
	private int velocidad;
	private int vida;
	
	public Cabeza(String nombre, int velocidad, int vida) {
		super(nombre);
		this.velocidad = velocidad;
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Cabeza [velocidad=" + velocidad + ", vida=" + vida + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
