package cl.ucn.taller03.dominio;

public class Brazo extends Pieza{

	private int ataque;
	
	public Brazo(String nombre, int ataque) {
		super(nombre);
		this.ataque = ataque;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	@Override
	public String toString() {
		return "Brazo [ataque=" + ataque + ", toString()=" + super.toString() + "]";
	}

	
}
