package cl.ucn.taller03.dominio;

public class Arma extends Pieza{
	
	private int daño;
	private int velocidadDeAtaque;
	
	public Arma(String nombre, int daño, int velocidadAtaque) {
		super(nombre);
		this.daño = daño;
		this.velocidadDeAtaque = velocidadAtaque;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getVelocidadDeAtaque() {
		return velocidadDeAtaque;
	}

	public void setVelocidadDeAtaque(int velocidadDeAtaque) {
		this.velocidadDeAtaque = velocidadDeAtaque;
	}

	@Override
	public String toString() {
		return "Arma [daño=" + daño + ", velocidadDeAtaque=" + velocidadDeAtaque + ", getNombre()=" + getNombre() + "]";
	}
	
	

}
