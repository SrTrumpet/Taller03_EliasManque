package cl.ucn.taller03.dominio;

public class RobotHumano extends Robot{
	
	private String nombrePiloto;
	private String equipoMantencion;
	
	public RobotHumano(String nombre, String nombrePiloto, String equipoMantencion) {
		super(nombre);
		this.nombrePiloto = nombrePiloto;
		this.equipoMantencion = equipoMantencion;
	}

	public String getNombrePiloto() {
		return nombrePiloto;
	}

	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

	public String getEquipoMantencion() {
		return equipoMantencion;
	}

	public void setEquipoMantencion(String equipoMantencion) {
		this.equipoMantencion = equipoMantencion;
	}
	
	

}
