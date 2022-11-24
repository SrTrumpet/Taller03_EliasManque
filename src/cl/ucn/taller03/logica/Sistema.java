package cl.ucn.taller03.logica;

public interface Sistema {
	
	void iniciarApp(Sistema sist);
	void guardarPieza(String info);
	void guardarRobot(String linea);
	String bucarListaRobotsPorPiloto(String text);
	String buscarListaRobotPorEquipo(String text);
	void guardarCombates(String linea);
	String buscarNombreArma(String nombreArma);
	String buscarRobot(String nombreRoboString);
	void cambiarArma(String arma, String nombreRobot);
	
	
	
}
