package cl.ucn.taller03.dominio;

public class RobotHumano extends Robot{
	
	private Piloto nombrePiloto;
	private Equipo equipoMantencion;
	
	
	public RobotHumano(String nombre, Piloto nombrePiloto, Equipo equipoMantencion) {
		super(nombre);
		this.nombrePiloto = nombrePiloto;
		this.equipoMantencion = equipoMantencion;
	}
	
	
	public Piloto getNombrePiloto() {
		return nombrePiloto;
	}
	public void setNombrePiloto(Piloto nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}
	public Equipo getEquipoMantencion() {
		return equipoMantencion;
	}
	public void setEquipoMantencion(Equipo equipoMantencion) {
		this.equipoMantencion = equipoMantencion;
	}
	
	
	
	

}
