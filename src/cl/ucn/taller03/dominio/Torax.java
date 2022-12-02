package cl.ucn.taller03.dominio;

public class Torax extends Pieza {

	private int vida;

	public Torax(String nombre, int vida) {
		super(nombre);
		this.vida = vida;
		// TODO Auto-generated constructor stub
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Torax [vida=" + vida + ", toString()=" + super.toString() + "]";
	}

}
