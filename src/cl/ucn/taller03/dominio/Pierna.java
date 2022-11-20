package cl.ucn.taller03.dominio;

public class Pierna extends Pieza{

	
	private int velocidad;
	
	public Pierna(String nombre, int velocidad) {
		super(nombre);
		this.velocidad = velocidad;
		// TODO Auto-generated constructor stub
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Pierna [velocidad=" + velocidad + ", toString()=" + super.toString() + "]";
	}

	
	
}
