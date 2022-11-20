package cl.ucn.taller03.dominio;

public class Pieza {

	private String nombre;
	private int vidaBase;
	private String rareza;
	private int ataqueExtra;

	public Pieza(String nombre) {
		this.nombre = nombre;
		this.vidaBase = 2000;
	}

	public void añadirMasVidaBase(int vidaExtra) {
		this.vidaBase += vidaExtra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public void setVidaBase(int vidaBase) {
		this.vidaBase = vidaBase;
	}

	public String getRareza() {
		return rareza;
	}

	public void setRareza(String rareza) {
		this.rareza = rareza;
	}

	public int getAtaqueExtra() {
		return ataqueExtra;
	}

	public void setAtaqueExtra(int ataqueExtra) {
		this.ataqueExtra = ataqueExtra;
	}

	@Override
	public String toString() {
		return "Pieza [nombre=" + nombre + ", vidaBase=" + vidaBase + ", rareza=" + rareza + ", ataqueExtra="
				+ ataqueExtra + "]";
	}

	
}
